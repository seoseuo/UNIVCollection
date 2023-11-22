## 축구 선수의 여러 속성에 따른 최고 이적료에 대한 분석 및 예측


### 데이터 소개
![image](https://github.com/seoseuo/Bigdata_project/assets/90320005/1a5c2794-ddeb-4dac-9abf-868b99274ff1)<br>
<b>Football Player Database | Top 5 Leagues - Soccer<b><br>
link : https://www.kaggle.com/datasets/oles04/top-leagues-player

  <pre> 5대 리그 2022/23 시즌의 마무리를 통해 수집된 플레이프로파일 데이터셋을 소개합니다. 본 데이터셋은 잉글리시
    프리미어 리그, 스페인 리가, 독일 분데스리가, 이탈리아 세리에 A, 그리고 프랑스 리그 1에서 경쟁 중인 선수들의
    플레이프로파일에 관한 귀중한 정보와 속성들을 제공합니다. 이 데이터셋에는 선수의 이름, 소속 구단, 포지션, 키,
    선호하는 발, 에이전트, 제작사 등과 같은 필수적인 세부 정보가 포함되어 있습니다. 이는 리서처, 분석가, 그리고 
    축구 애호가들을 위한 포괄적인 자료로, Top 5 축구 리그에서의 선수 성과를 탐험할 수 있게 해줍니다. </pre>


### 데이터 변수 종류

`name` : 이름 <br>
`full_name` : 전체 이름<br>
`age` : 나이 <br>
`height` : 키 (cm) <br>
`nationality` : 국적 <br>
`place_of_birth` : 출생장소 <br>
`price` : 현재 이적료 <br>
`max_price` : 최대 이적료 <br>
`position` : 포지션 <br>
`shirt_nr` : 등 번호 <br>
`foot` : 주 발 <br>
`club` : 소속 클럽 <br>
`contract_expires` : 계약 종료 <br>
`joined_club` : 계약 시작 <br>
`player_agent` : 에이전트 <br>
`outfitter` : 계약 <br>
`league` : 리그 <br>

<br><br>

### summary()
![image](https://github.com/seoseuo/Bigdata_project/assets/90320005/34d80ea1-3b7e-4ab2-9f9d-6759967930f3)

<br>

### 가설
1. 최대 이적료 즉 선수 개인의 최대 몸값은 주 발이 오른발이고 키와 나이가 해당 속성의 평균보다 작을 때 커진다.
2. 등 번호와 소속 리그, 소속 클럽은 최대 이적료 변동에 영향을 끼치지 않는다.

   



