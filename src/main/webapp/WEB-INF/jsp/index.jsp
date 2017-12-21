<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru" xml:lang="ru">
<head>
<link rel="stylesheet" href="/../css/index.css">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Банкомат</title>
<script>
function notnullexception(form)
{
  for (var i = 0; i < form.elements.length; i++)
  if (form.elements[i].value == '')
{
  alert ('Будь ласка заповніть всі поля!!!');
  return false;
}}
</script>
</head>
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
  <tr>
  <form method="post" action="/save" onsubmit="return notnullexception(this)">
      <td><input type="text" name="id" pattern="^[0-9]+$" style="height: 16px;width: 34px;text-align:center;"/></td>
      <td><select type="text" name="kname" style="height: 22px;width: 95px;text-align:center;";>
                      <option>10</option>
                      <option>20</option>
                      <option>50</option>
                      <option>100</option>
                      <option>200</option>
                      <option>500</option>
                    </select></td>
      <td><input type="datetime-local" name="dated" pattern="[0-9]{2}" style="height: 20px;width: 225px;text-align:center;"/></td>
      <td><select type="text" name="description" style="height: 22px;width: 189px;text-align:center;";>
                                <option>двадцять гривень</option>
                                <option>п&#39ятдесят гривень</option>
                                <option>сто гривень</option>
                                <option>двісті гривень</option>
                                <option>п&#39ятсот гривень</option>
                                <option>десять гривень</option>
                              </select></td>
      <td><select type="text" name="status" style="height: 22px;width: 87px;text-align:center;";>
            <option>true</option>
            <option>false</option>
          </select></td>
      <br>
      <input type="submit" value="Прийняти" style="width:290px;height:60px;color: #FFFF00;font-size: 1em;text-decoration: none;user-select: none; background: rgb(212,75,56);padding: .7em 1.5em; outline: none;text-align:center;float: right;position: fixed;top: 87%;left:78%"/>
    </form>
    </tr>
</table>
</body>
</html>
