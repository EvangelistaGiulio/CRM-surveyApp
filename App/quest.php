<?php

require 'connection.php';

$d1=$_POST["d1"];
$d2=$_POST["d2"];
$d3=$_POST["d3"];
$d4=$_POST["d4"];
$d5=$_POST["d5"];
$d6=$_POST["d6"];
$d7=$_POST["d7"];
$d8=$_POST["d8"];
$d9=$_POST["d9"];
$d10=$_POST["d10"];

$result=$connDB->query("INSERT INTO sceltecrm (d1, d2, d3, d4, d5, d6, d7, d8, d9, d10)"
        . "VALUES ('$d1', '$d2', '$d3', '$d4', '$d5', '$d6', '$d7', '$d8', '$d9', '$d10')");
if($result){
    echo 'Registrazione riuscita';
}else{
    echo 'Registrazione non riuscita';
}

?>

