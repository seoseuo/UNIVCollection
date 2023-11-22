# 축구 선수의 여러 속성에 따른 최고 이적료에 대한 분석 및 예측


## 데이터 소개
![image](https://github.com/seoseuo/Bigdata_project/assets/90320005/1a5c2794-ddeb-4dac-9abf-868b99274ff1)<br>
<b>Football Player Database | Top 5 Leagues - Soccer<b><br>
link : https://www.kaggle.com/datasets/oles04/top-leagues-player

  <pre> 5대 리그 2022/23 시즌의 마무리를 통해 수집된 플레이프로파일 데이터셋을 소개합니다. 본 데이터셋은 잉글리시
    프리미어 리그, 스페인 리가, 독일 분데스리가, 이탈리아 세리에 A, 그리고 프랑스 리그 1에서 경쟁 중인 선수들의
    플레이프로파일에 관한 귀중한 정보와 속성들을 제공합니다. 이 데이터셋에는 선수의 이름, 소속 구단, 포지션, 키,
    선호하는 발, 에이전트, 제작사 등과 같은 필수적인 세부 정보가 포함되어 있습니다. 이는 리서처, 분석가, 그리고 
    축구 애호가들을 위한 포괄적인 자료로, Top 5 축구 리그에서의 선수 성과를 탐험할 수 있게 해줍니다. </pre>


## 데이터 변수 종류

`name` : 이름 <br>
`full_name` : 전체 이름<br>
`age` : 나이 <br>
`height` : 키 (cm) <br>
`nationality` : 국적 <br>
`place_of_birth` : 출생장소 <br>
`price` : 현재 이적료 (1백만) <br>
`max_price` : 최대 이적료 (1백만) <br>
`position` : 포지션 <br>
`shirt_nr` : 등 번호 <br>
`foot` : 주 발 <br>
`club` : 소속 클럽 <br>
`contract_expires` : 계약 종료 <br>
`joined_club` : 계약 시작 <br>
`player_agent` : 에이전트 <br>
`outfitter` : 계약 <br>
`league` : 리그 <br>

## summary()
![image](https://github.com/seoseuo/Bigdata_project/assets/90320005/34d80ea1-3b7e-4ab2-9f9d-6759967930f3)

<br>

## 가설
1.
<pre>주 발이 오른발이고 포지션이 공격수인 선수들의 최대 이적료는 그렇지 않은 선수들보다 크다.</pre>


2.
<pre>등번호와 리그, 소속클럽 그리고 키는 최대 이적료에 영향을 끼치지 않는다.</pre>


## 1. 가설 검정법
`귀무가설 (H0)` : 주 발이 오른발이고 포지션이 공격수인 선수들의 최대 이적료 평균은 그렇지 않은 선수들과 다르지 않다. <br>
`대립가설 (H1)` : 주 발이 오른발이고 포지션이 공격수인 선수들의 최대 이적료 평균은 그렇지 않은 선수들보다 크다. <br>

### 검정 방법

`데이터 그룹화`<br>
주 발이 오른발이고 포지션이 공격수인 그룹과 그 외의 그룹으로 데이터를 나눕니다.

`독립 표본 t-검정:`<br>
두 그룹 간의 최대 이적료 평균 차이를 검정하기 위해 독립 표본 t-검정을 수행합니다.
귀무가설은 두 그룹 간의 평균 이적료 차이가 없다는 것입니다.

`통계적 유의성 확인`<br>
검정 결과에서 얻은 p-값을 확인합니다.
p-값이 유의수준 (예: 0.05)보다 작으면, 귀무가설을 기각하고 대립가설을 채택합니다.

`결과 해석`<br>
통계적으로 유의한 결과가 나왔을 경우, 주 발이 오른발이고 포지션이 공격수인 선수들의 최대 이적료 평균은 그렇지 않은 선수들보다 크다는 결론을 내릴 수 있습니다.

## 2. 가설 검정법
`귀무가설 (H0)` : 등번호, 리그, 소속클럽, 그리고 키는 최대 이적료에 영향을 끼치지 않는다.<br>
`대립가설 (H1)` : 적어도 하나의 변수가 최대 이적료에 영향을 끼친다.<br>

`상관 관계 분석` <br>
등번호, 리그, 소속클럽, 키 등의 변수와 최대 이적료 간의 상관 관계를 계산합니다.
상관 계수를 통해 변수들 간의 선형 관계를 확인할 수 있습니다.

`회귀 분석` <br>
다중 선형 회귀 분석을 통해 등번호, 리그, 소속클럽, 키가 최대 이적료에 미치는 영향을 통계적으로 분석합니다.
각 독립 변수의 계수와 p-값을 확인하여 영향의 정도와 통계적 유의성을 평가합니다.

`통계적 검정` <br>
회귀 분석 결과에서 등번호, 리그, 소속클럽, 키의 계수에 대한 p-값을 확인합니다.
각 변수에 대한 p-값이 일반적으로 사용되는 유의수준 (예: 0.05)보다 크면, 해당 변수는 최대 이적료에 통계적으로 유의미한 영향을 미치지 않는다고 판단할 수 있습니다.

`결과 해석` <br>
통계적으로 유의미한 영향이 없다면 귀무가설을 기각하고, 등번호, 리그, 소속클럽, 키는 최대 이적료에 영향을 미치지 않는다는 결론을 내릴 수 있습니다.
통계적으로 유의미한 영향이 있다면, 해당 변수는 최대 이적료에 영향을 미친다고 판단할 수 있습니다.

<hr>

## 추가 분석 및 예측
  결과를 확인하고 추후 데이터 셋에 등록 될 선수들의 이적료를 분석하거나 최대 이적료를 예측할 수 있다.
