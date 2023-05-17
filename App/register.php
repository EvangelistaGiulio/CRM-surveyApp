<?php
require 'connection.php';

$nome=$_POST["nome"];
$cognome=$_POST["cognome"];
$indirizzo=$_POST["indirizzo"];
$citta=$_POST["citta"];
$cod_fisc=$_POST["cod_fisc"];
$sesso=$_POST["sesso"];

$result=$connDB->query("INSERT INTO clienti (nome, cognome, indirizzo, citta, cod_fisc, sesso)"
        . "VALUES ('$nome', '$cognome', '$indirizzo', '$citta', '$cod_fisc', '$sesso')");
if($result){
    echo 'Registrazione riuscita';
}else{
    echo 'Registrazione non riuscita';
}
?>

