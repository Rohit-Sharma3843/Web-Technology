<?php include 'db.php';

$id = $_GET['id'];

$conn->query("DELETE FROM aircraft WHERE aircraft_id=$id");

header("Location: index.php");
?>