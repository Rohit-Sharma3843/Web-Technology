<?php include 'db.php'; ?>

<h2>Aircraft Table</h2>

<a href="add.php">Add Aircraft</a>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Type</th>
    <th>Manufacturer</th>
    <th>Quantity</th>
    <th>Actions</th>
</tr>

<?php
$result = $conn->query("SELECT * FROM aircraft");

while($row = $result->fetch_assoc()) {
?>
<tr>
    <td><?= $row['aircraft_id'] ?></td>
    <td><?= $row['aircraft_name'] ?></td>
    <td><?= $row['aircraft_type'] ?></td>
    <td><?= $row['manufacturer'] ?></td>
    <td><?= $row['quantity'] ?></td>
    <td>
        <a href="update.php?id=<?= $row['aircraft_id'] ?>">Edit</a>
        <a href="delete.php?id=<?= $row['aircraft_id'] ?>">Delete</a>
    </td>
</tr>
<?php } ?>
</table>