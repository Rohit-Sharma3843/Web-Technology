<?php include 'db.php';

if(isset($_POST['submit'])) {
    $name = $_POST['name'];
    $type = $_POST['type'];
    $manufacturer = $_POST['manufacturer'];
    $quantity = $_POST['quantity'];

    $conn->query("INSERT INTO aircraft 
    (aircraft_name, aircraft_type, manufacturer, quantity)
    VALUES ('$name', '$type', '$manufacturer', $quantity)");

    header("Location: index.php");
}
?>

<form method="POST">
    Name: <input type="text" name="name"><br>
    Type: <input type="text" name="type"><br>
    Manufacturer: <input type="text" name="manufacturer"><br>
    Quantity: <input type="number" name="quantity"><br>
    <button name="submit">Add</button>
</form>