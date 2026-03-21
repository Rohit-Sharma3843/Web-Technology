<?php
$conn = new mysqli("localhost", "root", "2704", "test");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>