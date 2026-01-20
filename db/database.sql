-- 테이블 생성
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,            -- 자동 증가 ID
                       username VARCHAR(50) NOT NULL,    -- 사용자명
                       email VARCHAR(100) NOT NULL,      -- 이메일
                       created_at TIMESTAMP DEFAULT NOW() -- 생성일시
);

-- 인덱스 추가
CREATE UNIQUE INDEX idx_users_email ON users(email);


-- 샘플 데이터 입력
INSERT INTO users (username, email) VALUES ('gildong', 'hong@example.com');
INSERT INTO users (username, email) VALUES ('chulsu', 'kim@example.com');
INSERT INTO users (username, email) VALUES ('younghee', 'lee@example.com');


-- 1. write_user 사용자 생성
CREATE USER write_user WITH PASSWORD 'postgres';

-- 2. 데이터베이스 연결 권한 부여
GRANT CONNECT ON DATABASE postgres TO write_user;

-- 3. 스키마 사용 권한 부여
GRANT USAGE, CREATE ON SCHEMA public TO write_user;

-- 4. 테이블 관련 모든 권한 부여
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO write_user;

-- 5. 시퀀스(ID 자동증가) 권한 부여 (INSERT 시 필수)
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO write_user;


-- 1. read_user 사용자 생성
CREATE USER read_user WITH PASSWORD 'postgres';

-- 2. 데이터베이스 연결 권한 부여
GRANT CONNECT ON DATABASE postgres TO read_user;

-- 3. 스키마 사용 권한 부여
GRANT USAGE ON SCHEMA public TO read_user;

-- 4. 현재 존재하는 모든 테이블에 SELECT 권한만 부여
GRANT SELECT ON ALL TABLES IN SCHEMA public TO read_user;

-- 5. (선택사항) 향후 생성될 테이블에도 자동으로 SELECT 권한 부여
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT SELECT ON TABLES TO read_user;
