package com.ibm.cache;


import java.util.Set;

import com.ibm.broker.javacompute.MbJavaComputeNode;
import com.ibm.broker.plugin.MbElement;
import com.ibm.broker.plugin.MbException;
import com.ibm.broker.plugin.MbMessage;
import com.ibm.broker.plugin.MbMessageAssembly;
import com.ibm.broker.plugin.MbOutputTerminal;
import com.ibm.broker.plugin.MbUserException;
import com.ibm.broker.plugin.MbJSON;
import com.ibm.broker.plugin.MbXMLNSC;

import redis.clients.jedis.Jedis;

public class GetCacheJavaCompute extends MbJavaComputeNode {

	public void evaluate(MbMessageAssembly inAssembly) throws MbException {
		MbOutputTerminal out = getOutputTerminal("out");
		MbOutputTerminal alt = getOutputTerminal("alternate");

		MbMessage inMessage = inAssembly.getMessage();
		MbMessageAssembly outAssembly = null;
		try {
			MbMessage outMessage = new MbMessage(inMessage);
			outAssembly = new MbMessageAssembly(inAssembly, outMessage);
			
			MbElement root = inAssembly
				.getMessage()
				.getRootElement();
			
			Jedis jedis = ConfigRedis.redisConnection();
			
			String key = null;
			boolean getKeys = false;
			
			try {
				key = root.getFirstElementByPath("/XMLNSC/Data/key").getValueAsString();
			} catch (NullPointerException e) {
				getKeys = true;
			}
			
			MbElement jsonElement = outMessage
					.getRootElement()
					.createElementAsLastChild(MbJSON.PARSER_NAME);
		
			MbElement jsonResponse = jsonElement
					.createElementAsLastChild(MbJSON.OBJECT, MbJSON.DATA_ELEMENT_NAME, null);
			
			MbElement json = null;
			
			if(getKeys) {
				Set<String> keys = jedis.keys("*");
				int n = keys.size();
		        String arraySet[] = new String[n];
		        arraySet = keys.toArray(arraySet);
		        
		        MbElement array = jsonElement.createElementAsLastChild(MbJSON.ARRAY, "keys", null);
		        
		        for(String s: arraySet) {
		        	array.createElementAsLastChild(MbElement.TYPE_NAME_VALUE, "Item", s);
		        }
			} else {
				String jsonString = jedis.get(key);
				byte[] jsonBytes = {};
				if(jsonString != null) {
					jsonBytes = jsonString.getBytes();
					json = jsonResponse
							.createElementAsLastChildFromBitstream(jsonBytes, MbJSON.PARSER_NAME, null, null, null, 0, 1208, 0);
				} else {
					json = jsonElement.createElementAsLastChild(MbJSON.OBJECT, MbJSON.PARSER_NAME, null);
				}
			}
			jedis.close();
		} catch (MbException | RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new MbUserException(this, "evaluate()", "", "", e.toString(), null);
		}
		out.propagate(outAssembly);
	}

	/**
	 * onPreSetupValidation() is called during the construction of the node
	 * to allow the node configuration to be validated.  Updating the node
	 * configuration or connecting to external resources should be avoided.
	 *
	 * @throws MbException
	 */
	@Override
	public void onPreSetupValidation() throws MbException {}

	/**
	 * onSetup() is called during the start of the message flow allowing
	 * configuration to be read/cached, and endpoints to be registered.
	 *
	 * Calling getPolicy() within this method to retrieve a policy links this
	 * node to the policy. If the policy is subsequently redeployed the message
	 * flow will be torn down and reinitialized to it's state prior to the policy
	 * redeploy.
	 *
	 * @throws MbException
	 */
	@Override
	public void onSetup() throws MbException {}

	/**
	 * onStart() is called as the message flow is started. The thread pool for
	 * the message flow is running when this method is invoked.
	 *
	 * @throws MbException
	 */
	@Override
	public void onStart() throws MbException {}

	/**
	 * onStop() is called as the message flow is stopped. 
	 *
	 * The onStop method is called twice as a message flow is stopped. Initially
	 * with a 'wait' value of false and subsequently with a 'wait' value of true.
	 * Blocking operations should be avoided during the initial call. All thread
	 * pools and external connections should be stopped by the completion of the
	 * second call.
	 *
	 * @throws MbException
	 */
	@Override
	public void onStop(boolean wait) throws MbException {}

	/**
	 * onTearDown() is called to allow any cached data to be released and any
	 * endpoints to be deregistered.
	 *
	 * @throws MbException
	 */
	@Override
	public void onTearDown() throws MbException {}
}
