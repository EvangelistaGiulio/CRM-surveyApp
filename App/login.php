<?php

require 'connection.php';
$userlog=$_POST["username"];
$passlog=$_POST["password"];
$result=$connDB->query("SELECT * FROM dipendenti WHERE username = '$userlog' AND password = '$passlog'");
if($result->num_rows!=0){
    echo 'Login riuscito';
}else{
    echo 'Login non riuscito, riprova';
}
?>

