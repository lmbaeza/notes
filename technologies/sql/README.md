# SQL

### PostgreSQL

#### Agregar y eliminar Indices

```sql
CREATE INDEX idx_name ON public.table_name USING btree (column_1, column_2, ... ,column_n);
DROP INDEX public.idx_name;
```