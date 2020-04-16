# Algo
- Algo는 온라인 저지 및 학습 서비스 입니다.
- Baekjoon Online Judge 및 Opentutorials.org의 클론 프로젝트입니다.

## Installation
### 저장소 다운로드
```cli
git clone https://github.com/team-puertea/Algo.git
```
### DB 설치 및 설정
1. Oracle 11g Express 설치
2. 계정 생성
3. 스키마 생성
    - `REPOSITORY_PATH/sql/algo_oracle_init.sql` 실행
4. 데이터베이스 연결 설정
    - `Algo/src/main/resources/config/database.properties` 생성
    - 예시파일 경로:  
        - `REPOSITORY_PATH/sql/database.properties` 

## Built With
- Spring 
    - 웹 프레임워크
    - MVC 
- JNA
    - Windows Native API에 접근
- CodeMirror  
    - 코드 편집기 
- Maven 
    - 의존성 관리 및 빌드


