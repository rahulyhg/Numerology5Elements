<?php
$servername = "localhost";
$username = "budimul1_eb";
$password = "4cesm4rt";
$dbname = "budimul1_numerology";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$user_email = $_POST['user_email'];
$device_id = $_POST['device_id'];
$user_password = $_POST['user_password'];
$phone_number = $_POST['phone_number'];
$sql = "INSERT INTO user (user_email,device_id, user_password, phone_number) VALUES ('$user_email', '$device_id','$user_password','$phone_number')";

if ($conn->query($sql) === TRUE) {
    //echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$sql = "SELECT id FROM user ORDER BY id DESC LIMIT 1";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
   $row = $result->fetch_assoc();
    
       echo $row["id"];
   
} else {
    echo "0 results";
}
$conn->close();

?>
