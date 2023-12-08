# EveryWeather 기획안



## 디자인
#### 아이디어
- `매일(Every)` 을 `날씨(Weather)` 와 함께 기록하는 다이어리. `EveryWeather`라는 이름을 착안

#### 폰트 에스코어 드림
<pre>@font-face {
     font-family: 'S-CoreDream-3Light';
     src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/S-CoreDream-3Light.woff') format('woff');
     font-weight: normal;
     font-style: normal;
}</pre>
  
<hr>

## 서비스
##### 시스템
- <b>날짜 및 위치에 따른 날씨 정보 최신화</b> (참고링크 - 1 확인)
- <b>사진 정보 저장</b>
- 날씨, 위치에 따른 게시글 필터링
- 달력 제공

#### 관리자
- 회원 가입 및 로그인
- 회원 목록 확인
- 회원 게시글 검색

#### 회원
- 회원가입 및 로그인
    <br>`아이디 중복 확인`
- 팔로잉
    <br>`다른 사용자를 팔로잉`
- 팔로잉 목록 확인
- 회원 검색
    <br>`사용하는 아이디로 팔로잉 한다.`
- 다이어리 작성
    <br>`작성 시 위치 데이터와 날씨 데이터가 함께 다이어리에 기록됨.`
    <br>`당일 이전으로 달력의 공간을 클릭하면 열람이 아닐 시 작성 화면으로 이동`
- 개인 및 팔로워 다이어리 열람
    <br>`당일 이후의 날짜라면 접근 불가능`
- 내 정보 확인 및 수정
    <br>`닉네임, 프로필 사진, 자기소개, 비밀번호 재설정`
- 날짜, 위치에 대한 필터링 검색 기능

`비즈니스적인 추가기능 필요 요망 , , , `
<hr>

## 폴더링
`지속적으로 추가 예정`
![image](https://github.com/seoseuo/EveryWeather/assets/90320005/6766fa62-e094-4748-81df-e0f438030643)




#### com.everyweather
- com.everyweather.admin
  * 컨트롤러
  * 서비스
  * Dao
  * 객체
    
- com.everyweather.member
  * 컨트롤러
  * 서비스
  * Dao
  * 객체
    
- com.everyweather.diary
  * 컨트롤러
  * 서비스
  * Dao
  * 객체

#### /views
-  메인 화면
- 로그인 화면
- 회원 가입 화면
  
- /admin
  * 관리자 메인 화면
  * 관리자 회원 목록 화면
  * 관리자 회원 상세 정보 (가입 일자, 팔로잉 회원 등)
  * 관리자 다이어리 검색 화면
  * 관리자 다이어리 검색 결과 화면
  * 관리자 다이어리 뷰 화면

- /member
  * 회원 화면
  * 회원 검색 화면
  * 회원 검색 결과 화면
  * 회원 정보 화면
  * 회원 정보 수정 화면
  * 회원 필터링 검색
  * 회원 필터링 검색 결과
 
- /diary
  * 다이어리 열람 화면
  * 다이어리 작성 화면
  * 다이어리 수정 화면
<hr>

## 시나리오 순서도

#### 공통
- 회원가입  
- 로그인

#### 관리자
- 회원 목록 확인
    * 회원 관리
- 내 정보 확인
- 다이어리 검색

#### 회원
- 달력 클릭
    * 다이어리 열람
      + 다이어리 수정
    * 다이어리 작성
        - 작성 시 현재 날씨와 사진의 위치 정보가 함께 기재

- 달력 이동
- 회원 검색
    * 검색 결과 확인
    * 팔로우

- 팔로잉 목록 클릭
    * 팔로우 취소
    * 팔로잉 메인 페이지

- 필터링 검색
    * 필터링 검색 결과
    * 필터링 검색 결과 다이어리 열람
  
<hr>

## 컨트롤러 및 이동url
2023.12.08
`동작`이 아닌 `이동`에 대한 url 임. 헷갈리지 않도록 적어놓음
<code>package com.everyweather.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//MemberController.java

@Controller
@RequestMapping("/member")
public class MemberController {

	String nextPage;

	@GetMapping("/member_main")
	public String member_main() {
		System.out.println("[MemberController] member_main.jsp");
		nextPage = "member/member_main";
		return nextPage;
	}
	
	@GetMapping("/member_search_id")
	public String member_search_id() {
		System.out.println("[MemberController] member_search_id.jsp");
		nextPage = "member/member_search_id";
		return nextPage;
	}
	
	@GetMapping("/member_search_diary")
	public String member_search_diary() {
		System.out.println("[MemberController] member_search_diary.jsp");
		nextPage = "member/member_search_diary";
		return nextPage;
	}
	
	@GetMapping("/member_info")
	public String member_info() {
		System.out.println("[MemberController] member_info.jsp");
		nextPage = "member/member_info";
		return nextPage;
	}
	
	@GetMapping("/member_info_edit")
	public String member_info_edit() {
		System.out.println("[MemberController] member_info_edit.jsp");
		nextPage = "member/member_info_edit";
		return nextPage;
	}
	
	@GetMapping("/member_following_view")
	public String member_following_view() {
		System.out.println("[MemberController] member_following_view.jsp");
		nextPage = "member/member_following_view";
		return nextPage;
	}
	
	
	@GetMapping("/member_diary_my_view")
	public String member_diary_view() {
		System.out.println("[MemberController] member_diary_my_view.jsp");
		nextPage = "member/member_diary_my_view";
		return nextPage;
	}
	
	@GetMapping("/member_diary_following_view")
	public String member_diary_following_view() {
		System.out.println("[MemberController] member_diary_following_view.jsp");
		nextPage = "member/member_diary_following_view";
		return nextPage;
	}
	
	@GetMapping("/member_diary_my_write")
	public String member_diary_write() {
		System.out.println("[MemberController] member_diary_my_write.jsp");
		nextPage = "member/member_diary_my_write";
		return nextPage;
	}

	@GetMapping("/member_diary_my_edit")
	public String member_diary_edit() {
		System.out.println("[MemberController] member_diary_my_edit.jsp");
		nextPage = "member/member_diary_my_edit";
		return nextPage;
	}
	
	
}
</code>

12.08
- 로그아웃 시 위치 정보 해제하는 `navigator.geolocation.clearWatch()` 사용

## 데이터 베이스
![image](https://github.com/seoseuo/EveryWeather/assets/90320005/e6d0cfc6-78da-487f-85f3-a9c0402789f1)

- member 데이터 베이스에 가입 날짜 추가할 것.
<hr>

## 참고 링크
- 1. https://velog.io/@j-jae0/LikeLion-TIL-220916-2
