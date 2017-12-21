<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ru" xml:lang="ru">
<head>
<script>
function notnullexception(form)
{
  for (var i = 0; i < form.elements.length; i++)
  if (form.elements[i].value == '')
{
  alert ('Введіть в поле потрібну вам суму грошей!');
  return false;
}}
function myFunction() {
    document.getElementById("vis").style.visibility = "visible";
}
</script>
<link href="/../css/depos.css" rel="stylesheet">
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Банкомат</title>
</head>
<body style="background-color : #FFE4C4">
<table class="tb1" align = "left">
 <tr>
    <th>Купюра</th>
    <th>Кількість</th>
  </tr>
    <c:forEach var = "list" items = "${lists}">
  <tr>
    <td>${list.kname}</td>
    <td>${list.kilk}</td>
  </tr>
  </c:forEach>
</table>
  <form method="get" action="/deposit/" onsubmit="return notnullexception(this)">
  <div style ="height:500px;width:370px;color:rgb(212,75,56);float: center;position: fixed;border: 4px inset orange;right:37%">
  <p style="color: #008000;font-size: 1em;float: center;position: fixed;;top:2%;right:39%"><ins>Знімати лише можна суму грошей кратну 10!</ins></p>
     <p style="color: rgb(212,75,56);font-size: 1.5em;float: center;position: fixed;top:20%;right:39.5%">Введіть потрібну вам суму:</p>
      <input type="text" name="kname" pattern="[0-9]{0,}(0)" style="height: 55px;width: 286px;text-align:center;float: center;position: fixed;top: 30%;font-size: 2em;right:40%"/>
      <input type="submit" value="Зняти гроші" style="width:290px;height:60px;color: #FFFF00; font-size: 1em;text-decoration: none; user-select: none; background: rgb(212,75,56); padding: .7em 1.5em; outline: none;float: center;position: fixed;top: 40%;right:40%"/>
   <p id="vis" style="color: rgb(212,75,56);font-size: 1.5em;float: center;position: fixed;;top:47%;right:39%;"><ins>Було знято наступні купюри:<br></ins><strong>${kname}</strong></p>
    </form>
</div>
<div class="dc1">
<button class="btt1" onclick='window.open("http://localhost:63342/atm/templates/html/view.html", target="_self")'>Назад</button>
</div>
</body>
</html>
