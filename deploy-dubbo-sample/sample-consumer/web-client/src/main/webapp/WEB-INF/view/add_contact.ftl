<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>add contact</title>
</head>
<body>
<p>Hello! ${info} </p>
<form action="/${type}/contact/add" method="post">
    <input name="name" value="tom" /><br>
    <input name="phone" value="12345678" /><br>
    <input name="email" value="test@qq.com" /><br>
    <input name="address.country" value="中国" /><br>
    <input name="address.province" value="广东" /><br>
    <input name="address.city" value="广州" /><br>
    <input name="address.street" value="中山路" /><br>
    <input name="address.zipCode" value="123" /><br>
    <input name="memo" value="从页面添加的联系人" /><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>