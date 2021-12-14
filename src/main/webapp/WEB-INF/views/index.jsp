<%--
  Created by IntelliJ IDEA.
  User: Tien Dung
  Date: 12/14/2021
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Email Validation</title>
  <title>The World Clock</title>
  <style type="text/css">
    select {
      width: 200px;
      height: 20px;
    }
  </style>
</head>
<body>

<h1>Email Validate</h1>
<h3 style="color:red">${message}</h3>

<form action="validate" method="post">
  <input type="text" name="email"><br>
  <input type="submit" value="Validate">
</form>


<h2>Current Local Times Around the World</h2>
<span>Current time in ${city}: <strong>${date}</strong></span>
<form id="locale" action="world-clock" method="get">
  <select name="city" onchange="document.getElementById('locale').submit()">
    <option value="Asia/Ho_Chi_Minh" selected>Select a city</option>
    <option value="Asia/Ho_Chi_Minh">Ho Chi Minh</option>
    <option value="Singapore">Singapore</option>
    <option value="Asia/Hong_Kong">Hong Kong</option>
    <option value="Asia/Tokyo">Tokyo</option>
    <option value="Asia/Seoul">Seoul</option>
    <option value="Europe/London">London</option>
    <option value="Europe/Madrid">Madrid</option>
    <option value="America/New_York">New York</option>
    <option value="Australia/Sydney">Sydney</option>
    <option value="Argentina/Buenos_Aires">Buenos Aires</option>
  </select>
</form>
<br>
<form action="/submit">
  <input type="checkbox" name="condiment" value="Lettuce"> Lettuce
  <input type="checkbox" name="condiment" value="Tomato">  Tomato
  <input type="checkbox" name="condiment" value="Mustard"> Mustard
  <input type="checkbox" name="condiment" value="Sprouts"> Sprouts
  <button>Save</button>
</form>
<form  action="/calculator">
  <input type="text" name="numberA" value="${numberA}">
  <input type="text" name="numberB" value="${numberB}">
  <button name="result" value="Cong">+</button><button name="result" value="tru">-</button><button name="result" value="nhan">X</button><button name="result" value="chia">/</button>
</form>
</body>
</html>
