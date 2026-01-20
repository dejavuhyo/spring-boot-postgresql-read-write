# Spring Boot PostgreSQL Read Write Separation

## 1. 설명
Spring Boot에서 PostgreSQL의 Read, Write 계정을 분리하여 select는 Read를 사용하고 insert, update, delete는 Write 계정을 사용하는 예제이다. 포트는 8080을 사용한다.

## 2. 개발환경

* OpenJDK 21

* spring-boot 4.0.1

* spring-web 4.0.1

* lombok 1.18.38

* PostgerSQL 17.7

## 3. 실행

### 1) 사용자 등록 (Write 테스트)

* Method: `POST`

* URL: `http://localhost:8080/api/users`

* Body (JSON):

```json
{
  "username": "test_user",
  "email": "test@example.com"
}
```

### 2) 특정 사용자 조회 (Read 테스트)

* Method: `GET`

* URL: `http://localhost:8080/api/users/1`

### 3) 전체 사용자 목록 조회 (Read 테스트)

* Method: `GET`

* URL: `http://localhost:8080/api/users`

### 4) 사용자 수정 (Write 테스트)

* Method: `PUT`

* URL: `http://localhost:8080/api/users/1`

* Body (JSON):

```json
{
  "username": "updated_name",
  "email": "updated@example.com"
}
```

### 5) 사용자 삭제 (Write 테스트)

* Method: `DELETE`

* URL: `http://localhost:8080/api/users/1`
