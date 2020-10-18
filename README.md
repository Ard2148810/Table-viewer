# **SQL Table viewer**

_deployed at: https://sql-tables.herokuapp.com/_
<br/><br/>
App allows to view and modify SQL table with real-time updates. It's written in Spring Boot 2 and React. It uses OAuth2 Google API in order to authorize clients.
<br/><br/>
**Installation:**
1. git: `git clone https://github.com/Ard2148810/Table-viewer`
2. configure database connection<br/>
  2.1. Create postgres database<br/>
  2.2. Set following environment variables in _application.properties_ file with your DB values:
    * STV_DB_URL
    * STV_DB_USER
    * STV_DB_PASS
2. maven: `spring-boot:run`
