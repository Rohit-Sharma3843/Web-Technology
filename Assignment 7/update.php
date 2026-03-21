<?php include 'db.php';

$id = $_GET['id'];

if(isset($_POST['update'])) {
    $name = $_POST['name'];
    $type = $_POST['type'];
    $manufacturer = $_POST['manufacturer'];
    $quantity = $_POST['quantity'];

    $conn->query("UPDATE aircraft SET 
    aircraft_name='$name',
    aircraft_type='$type',
    manufacturer='$manufacturer',
    quantity=$quantity
    WHERE aircraft_id=$id");

    header("Location: index.php");
}

$result = $conn->query("SELECT * FROM aircraft WHERE aircraft_id=$id");
$row = $result->fetch_assoc();
?>

<form method="POST">
    Name: <input type="text" name="name" value="<?= $row['aircraft_name'] ?>"><br>
    Type: <input type="text" name="type" value="<?= $row['aircraft_type'] ?>"><br>
    Manufacturer: <input type="text" name="manufacturer" value="<?= $row['manufacturer'] ?>"><br>
    Quantity: <input type="number" name="quantity" value="<?= $row['quantity'] ?>"><br>
    <button name="update">Update</button>
</form>