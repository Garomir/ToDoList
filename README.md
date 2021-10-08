<h1>Проект "ToDo List"</h1>
<ul>
  <li><a href="#description">Описание</a></li>
  <li><a href="#functionality">Функционал</a></li>
  <li><a href="#tehnologies">Технологии</a></li>
  <li><a href="#architecture">Архитектура</a></li>
  <li><a href="#interface">Интерфейс</a></li>
  <li><a href="#author">Автор</a></li>
</ul>
<h2><a name="description">Описание</a></h2>
  <h4>Клиент-серверное CRUD приложение для создания заметок. Для работы с данными из БД MySQL используется Hibernate. Регистрация с помощью Spring Security. Каждый зарегестрированный пользователь имеет доступ только к своим заметкам.</h4>
<h2><a name="functionality">Функционал</a></h2>
  <ul>
    <li>Регистрация пользователя</li>
    <li>Аутентификация</li>
    <li>Создание новой заметки</li>
    <li>Отображение списка всех заметок пользователя</li>
    <li>Удаление заметки</li>
    <li>Пометить заметку как выполненную</li>
  </ul>
<h2><a name="tehnologies">Технологии</a></h2>
  <ul>
    <li>Spring Boot</li>
    <li>Spring Data Jpa</li>
    <li>Hibernate</li>
    <li>MySQL</li>
    <li>Java 11</li>
    <li>Spring Security</li>
    <li>Thymeleaf</li>
    <li>HTML, Bootstrap</li>
  </ul>
<h2><a name="architecture">Архитектура</a></h2>
  <h4>Проект реализован по шаблону MVC и разделён на слои:</h4>
  <ol>
    <li>
      <p>Сущности данных:</p>
      <p>1.1 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/entities/Note.java">Note</a> - Модель заметки из БД</p>
      <p>1.2 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/entities/User.java">User</a> - Модель пользователя из БД</p>
      <p>1.3 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/entities/Role.java">Role</a> - Модель роли пользователя из БД</p>
    </li>
    <li>
      <p>Репозитории Jpa:</p>
      <p>2.1 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/repos/NoteRepo.java">NoteRepo</a> - Интерфейс для взаимодействия с заметками из БД</p>
      <p>2.2 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/repos/UserRepo.java">UserRepo</a> - Интерфейс для взаимодействия с пользователями из БД</p>
      <p>2.3 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/repos/RoleRepo.java">RoleRepo</a> - Интерфейс для взаимодействия с ролями пользователей из БД</p>
    </li>
    <li>
      <p>Сервисный слой с бизнес-логикой:</p>
      <p>3.1 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/services/NoteService.java">NoteService</a> - Интерфейс со списком методов по работе с заметками</p>
      <p>3.2 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/services/NoteServiceImpl.java">NoteServiceImpl</a> - Реализация методов из интерфейса NoteService</p>
      <p>3.3 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/services/UserService.java">UserService</a> - Интерфейс со списком методов по работе с пользователями</p>
      <p>3.4 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/services/UserServiceImpl.java">UserServiceImpl</a> - Реализация методов из интерфейса UserService</p>
      <p>3.5 <a href="https://github.com/Garomir/ToDoList/blob/main/src/main/java/com/ramich/ToDoList/services/UserDetailsServiceImpl.java">UserDetailsServiceImpl</a> - Реализация интерфейса UserDetailsService для преобразования пользователя в UserDetails</p>
    </li>
  </ol>
<h2><a name="interface">Интерфейс</a></h2>
  <ul>
    <li>
      <p>Стартовая страница</br>
        <a href="https://github.com/Garomir/ToDoList/blob/main/img/home.JPG">
          <img src="https://github.com/Garomir/ToDoList/blob/main/img/home.JPG" alt="ScreenShot" style="max-width: 100%;">
        </a>
      </p>  
    </li>
    <li>
      <p>Интерфейс</br>
        <a href="https://github.com/Garomir/ToDoList/blob/main/img/interface.JPG">
          <img src="https://github.com/Garomir/ToDoList/blob/main/img/interface.JPG" alt="ScreenShot" style="max-width: 100%;">
        </a>
      </p>  
    </li>
    <li>
      <p>Регистрация</br>
        <a href="https://github.com/Garomir/ToDoList/blob/main/img/registration.JPG">
          <img src="https://github.com/Garomir/ToDoList/blob/main/img/registration.JPG" alt="ScreenShot" style="max-width: 100%;">
        </a>
      </p>  
    </li>
    <li>
      <p>Аутентификация</br>
        <a href="https://github.com/Garomir/ToDoList/blob/main/img/login.JPG">
          <img src="https://github.com/Garomir/ToDoList/blob/main/img/login.JPG" alt="ScreenShot" style="max-width: 100%;">
        </a>
      </p>
    </li>
    <li>
      <p>Добавление заметки</br>
        <a href="https://github.com/Garomir/ToDoList/blob/main/img/addnote.JPG">
          <img src="https://github.com/Garomir/ToDoList/blob/main/img/addnote.JPG" alt="ScreenShot" style="max-width: 100%;">
        </a>
      </p>
    </li>
    <li>
      <p>Отметка о выполнении</br>
        <a href="https://github.com/Garomir/ToDoList/blob/main/img/setdone.JPG">
          <img src="https://github.com/Garomir/ToDoList/blob/main/img/setdone.JPG" alt="ScreenShot" style="max-width: 100%;">
        </a>
      </p>
    </li>
  </ul>
<h2><a name="author">Автор</a></h2>
  <p>Сафуанов Рамиль</p>
  <p>Java-разработчик</p>
  <p><a href="mailto:ramilfin@mail.ru">ramilfin@mail.ru</a></p>
  <p>+7 9172282922</p>
