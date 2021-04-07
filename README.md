# VideoRental Refactoring

AA C2차 11팀


Refactoring
#1 Video 부분 수정 (Object-Oriented Abusers의 Switch Statement)
: VHS, CD, DVD 이외 신규 미디어 종류 들어오면 전체 시스템에 영향 줄수 있어 
  Video의 Subclassing 실시하고, Polymorphism 이용하도록 
  penalty, limit 등을 Polymorphim 통해 return 되도록 함 
![VideoSubclassing](https://user-images.githubusercontent.com/82075490/113815930-ebbbf700-97ae-11eb-93e7-c56a9bebed82.PNG)

