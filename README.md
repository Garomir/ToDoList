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
  </ol>
<h2><a name="interface">Интерфейс</a></h2>

<h2><a name="author">Автор</a></h2>
