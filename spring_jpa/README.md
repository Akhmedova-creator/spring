Приложение хранящее информацию о книгах в библиотеке


Использовать JPA, Hibernate только в качестве JPA-провайдера.

Для решения проблемы N+1 можно использовать специфические для Hibernate аннотации @Fetch.

Покрыт репозитории тестами, используя H2 базу данных и соответствующий H2 Hibernate-диалект для тестов.

Используется DDL через Hibernate только для update

@Transactional стоит только на методах сервиса.