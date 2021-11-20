# Kafka CDC with Spring DDD

Spring에서 간략히 DDD 개념을 적용하고 Kafka를 이용해 CDC, Heterogeneous Databases Replication를 구현한 예제입니다.

목표
- 각 Domain별 Application은 Loose Coupled를 유지한다.
- Kafka를 이용하여 RDBMS(MySQL) -> NoSQL(Mongo)로 복제한다.
- CQRS 개념을 적용하여 Command는 RDBMS(MySQL), Query는 NoSQL(Mongo)에서 한다

실행방법


