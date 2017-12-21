<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru" xml:lang="ru">
<head>
<link href="/../css/search.css" rel="stylesheet">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Банкомат</title>
</head>
<script>
function notnullexception(form)
{
  for (var i = 0; i < form.elements.length; i++)
  if (form.elements[i].value == '')
{
  alert ('Введіть в поле потрібну вам купюру!');
  return false;
}}
</script>
<body style="background-color : #FFE4C4">
<div class ="dc1">
<button class="btt1" onclick='window.open("http://localhost:63342/atm/templates/html/view.html", target="_self")'>Назад</button>
</div>
<table align = "center">
 <tr>
    <th>ID</th>
    <th>Купюра</th>
    <th>Дата занесення</th>
    <th>Номінал</th>
    <th>Статус</th>
  </tr>
    <c:forEach var = "list" items = "${lists}">
  <tr>
    <td>${list.id}</td>
    <td>${list.kname}</td>
    <td>${list.dated}</td>
    <td>${list.description}</td>
    <td>${list.status}</td>
  </tr>
  </c:forEach>
 <table>
  <form method="get" action="/search/" onsubmit="return notnullexception(this)">
  <div style ="height:500px;width:297px;color:rgb(212,75,56);float: left;position: fixed;right:77.7%;top: 0; border: 4px inset orange;">
      <input type="text" name="kupura" pattern="[0-9]{0,3}" style="height: 55px;width: 286px;text-align:center;float: left;position: fixed;top: 20%;font-size: 2em;"/>
      <input type="submit"  value="Пошук купюри" style="width:290px;height:60px;color: #FFFF00; font-size: 1em;text-decoration: none; user-select: none; background: rgb(212,75,56); padding: .7em 1.5em; outline: none;float: left;position: fixed;top: 30%;"/>
    </form>
    <p style="color: rgb(212,75,56);font-size: 1.5em;float: left;position: fixed;top: 0">Загальний баланс банкомату<br> становить <ins><strong>${account}</strong></ins> грн.</p>
   <p style="color: rgb(212,75,56);font-size: 1.5em;float: left;position: fixed;top: 40%">Даних купюр в банкоматі : <ins><strong>${count}</strong></ins></p>
    </div>
</body>
</html>
