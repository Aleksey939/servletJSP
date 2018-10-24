
<%@page isELIgnored="false" contentType="text/html;charset=utf-8"%>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <meta charset="utf-8">
</head>
<body>
<h2>Index</h2>


<b>Добавление товара в БД</b></br>
<form method='post'>
    <label> Введите название товара : <input name='name'/>
        </label>
    <label> Введите описание товара : <input type="text" size="30s" name='desc'/>
        </label>
    <label> Введите цену товара : <input type="number" name='price'/>
        </label>
    <input type='submit'/>
</form>
<a href="all_products">Все продукты </a>

</body>
</html>
