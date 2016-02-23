# eej-utilities

This package main goal is to provide a basic mapping between data entities (as pojos) and a DataTables with server-side paging and filtering

The complete suite is built by using together this eej-utilities, eej-spring-utilities and eej-database-utilities, but all this three are packaged separetely to make possible the reutilization of some of the components.

Actually, this eej-utilities part have no dependencies on Spring or Hibernate, while eej-spring utilities has dependencies on Spring and database has on Hibernate. This is the main reason for doing this way.

When all pieces set, generating a Data Tables server-side pagination directly from data objects such as pojos, with full operational dynamic filtering is trivial.

The configuration is quite complex (TODO: shorthand classes with default simple configuration), but once done, getting a view page for each entity is easy and quick
