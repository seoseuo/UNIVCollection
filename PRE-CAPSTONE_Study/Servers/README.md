# APACHE TOMCAT

# Apache ?

### Apache의 개념

- Apache란 아파치 소프트웨어 재단에서 관리하는 ***HTTP 웹 서버***이다.
- 오픈소스이기 때문에 누구든지 수정, 재배포가 가능하다.
- Apache는 다양한 기능을 제공, 다른 ***웹 서버***들에 비해 구축이 쉽다.

### 웹 서버 ?

- 클라이언트가 `GET`, `POST` 등의 메소드를 이용해 전송한 요청을 받아 HTML이나 오브젝트를 HTTP 프로토콜을 이용해 전송하는 프로그램이다.
- 웹 서버는 웹 페이지, 이미지 등의 ***정적인 컨텐츠***만 제공할 수 있다.

![Untitled](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F63fa60bd-7fc5-45eb-af72-d41c6d6eb67d%2FUntitled.png?id=9ec23e8d-6e90-43ea-be06-abe70f7ccd06&table=block&spaceId=f02911ff-a5c6-4c9a-ae3e-63ed719e4cfe&width=1540&userId=fc7411bc-598e-431d-b643-0d71559a3db0&cache=v2)

### 웹 서버가 필요한 이유

- 웹 프로그램은 클라이언트 - 서버 컴퓨터 사이의 데이터 교환을 목적으로 하기 때문에 네트워크 통신이 반드시 필요하다.
- 웹 프로그램마다 네트워크 통신기능을 ***매번 직접 구현하는 것은 번거롭다.***
- 네트워크 통신을 구현하기 위해 미리 만들어진 프로그램을 사용하는데 웹 서버와 웹 브라우저가 이에 해당한다.

---

# Tomcat의 개념

- Tomcat이란 아파치 재단에서 만든 오픈소스 ***WAS (Web Application Server)***
- Tomcat은 ***JAVA Servlet***과 ***JSP***가 실행 할 수 있는 환경을 제공하여 동적 페이지를 생성한다.
- DB 연결 및 데이터 조작, 다른 응용프로그램들과 상호 작용이 가능하다.

![Untitled](https://www.notion.so/image/https%3A%2F%2Fs3-us-west-2.amazonaws.com%2Fsecure.notion-static.com%2F775819dc-5faf-48bf-b2fe-35a5f7f547da%2FUntitled.png?id=b8dd5ecf-6348-4085-9027-eb2d2975708e&table=block&spaceId=f02911ff-a5c6-4c9a-ae3e-63ed719e4cfe&width=1390&userId=fc7411bc-598e-431d-b643-0d71559a3db0&cache=v2)

> 이미지 참조: [https://doitnow-man.tistory.com/109](https://doitnow-man.tistory.com/109)
> 

### WAS (Web Application Server) ?

- WAS란 ***웹 서버와 웹 컨테이너의 결합***으로 이루어진 소프트웨어이다.
- 웹 서버를 포함하고 있기 때문에 ***웹 서버처럼 사용이 가능***하다.
- DB와 연결되어 트랜잭션 처리를 하거나 다른 시스템과의 연동 기능 또한 포함하고 있다.
- 웹 서버와 달리 요청에 대해 동***적인 페이지를 만들어*** 유연하게 응답 가능하다.

### WAS의 필요성

- ***웹 서버는 정적인 컨텐츠만 제공***하기 때문에 클라이언트의 ***요구에 유연하게 대처할 수 없***다.
- 다양한 클라이언트의 요구에 유연하게 대처하기 위해 DB와 연결해 데이터를 주고 받거나 데이터를 조작하여 ***동적인 페이지를 생성해 응답하기 위해*** WAS를 사용한다.

### Tomcat의 디렉터리 구조

- **`Bin`**:  톰캣 서버의 동작을 제어할 수 있는 스크립트 및 실행 파일
- `**Conf**`: 톰캣의 기본적인 설정 파일
- `**Lib`:** 아파치와 같은 다른 웹 서버와 톰캣을 연결해주는 바이너리 모듈들
- `**Webapps**`: 톰캣이 제공하는 웹 어플리케이션의 기본 위치
- `**Logs**`: 서버의 로그 파일이 저장
- `**Work**`: jsp 컨테이너와 다른 파일들이 생성하는 임시 디렉토리
- `**Temp**`: 임시 저장 폴더

---

# ****Apache Tomcat?****

> 아파치 톰캣(Apache Tomcat)은 아파치 소프트웨어 재단에서 개발한 서블릿 컨테이너(또는 웹 컨테이너)만 있는 웹 애플리케이션 서버이다.

톰캣은 웹 서버와 연동하여 실행할 수 있는 자바 환경을 제공하여 자바서버 페이지(JSP)와 자바 서블릿이 실행할 수 있는 환경을 제공하고 있다. 톰캣은 관리툴을 통해 설정을 변경할 수 있지만, XML 파일을 편집하여 설정할 수도 있다. 그리고, 톰캣은 HTTP 서버도 자체 내장하기도 한다.

아파치 톰캣은 Apache Licence, Version 2를 채용한 오픈소스 소프트웨어로서, 자바서버 페이지이나 자바 서블릿를 실행하기 위한 서블릿 컨테이너를 제공하며, 상용 웹 애플리케이션 서버에서도 서블릿 컨테이너로 사용하는 경우가 많다. 버전 5.5 이후는 기본적으로 Java SE 5.0 이후를 대응한다.
> 

`Apache Tomcat`은 JAVA Servlet을 이용하여 데이터 요청에 대한 응답을 자바 코드로 처리하고, 해당 내용을 유저에게 리턴에주는 구조이다.

python을 이용한 Django , Ruby를 이용한 Pby on Rails, Javascript를 이용한 Node.js처럼 Java를 이용하여 웹 서비스를 생성할 수 있습니다.

현재, 다양한 기업들에서 이를 이용하여 다양한 웹 서비스를 생성하고 있습니다.

이 때, `Servlet`을 이용하는데 , `Servlet`이란 자바 웹 어플리케이션의 구성 요소 중 JAVA언어를 사용하여 동적인 처리를 하는 역할을 담당합니다. Servlet은 WAS에 동작하는 JAVA클래스이며, HttpServlet을 상속받아야 합니다.
