# Practice

Проект выполнен в рамках прохождения обучения в Bellintegrator.

Приложение предназначено для предоставления данных в виде JSON, сформированных из запроса к информации хранеящейся в Базе Данных

Ссылка для скачивания: https://github.com/Killo200/practice

<h3>Запуск программы</h3>
  В консоли перейти в папку с проектом, выполнить:
  
  mvn spring-boot:run
  
  или запустить в среде разработки IDEA:
  
  File->Open
  Выбрать файл pom.xml в корневой папке проекта
  
  Ok->Open as Project -> Run 'PracticeApplication'

После этого по адресу <a href="http://localhost:8888/swagger-ui.html"> localhost:8888/swagger-ui.html </a> будут доступны необходимые запросы. 

![swagger-ui](https://github.com/killo200/practice/blob/master/scrn/sawgger-ui.png?raw=true)

<h3>Пример запросов к данным по организации:</h3>

Открыть вкладку organization-controller:

![organizationView](https://github.com/killo200/practice/blob/master/scrn/organizationView.png?raw=true)

1. Выбрать вкладку получить организацию по ID и указать номер ID:

результат ответа если организация с данным ID есть в БД

![organizationViewG](https://github.com/killo200/practice/blob/master/scrn/answer200byid.png?raw=true)

результат ответа если организация с данным ID нет в БД

![organizationViewBad](https://github.com/killo200/practice/blob/master/scrn/answer404byid.png?raw=true)

2. Выбрать вкладку получить список организаций, подходящих по фильтру:

![Filter](https://github.com/killo200/practice/blob/master/scrn/Filter.png?raw=true)

результат ответа если в БД есть организации подходящие по фильтру

![Filter](https://github.com/killo200/practice/blob/master/scrn/Filteranswer200.png?raw=true)

результат ответа если запрос к БД не верный

![Filter](https://github.com/killo200/practice/blob/master/scrn/Filteranswer500.png?raw=true)

Овет содержит код ошибки, который логируется для дальнейшего выяснения причин на стороне сервера
