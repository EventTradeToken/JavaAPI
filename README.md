# JavaAPI для работы с контрактом

##Создать новый контракт:
 ```EventTradeToken ett = contractAPI.createContract();```
 
##Получить существующий:
 ```EventTradeToken ett = contractAPI.getContract();```
 Для этого адрес контракта должен выть в проперти файле contract.properties
 В формате: contract.address=0xDEcC912aa8F69b3529AD1097eCf471731D25B6A3
 
 Для работы с либой должны быть выставлены опции виртуальной машины:
-DwalletPassword=<ПАРОЛЬ ОТ КОШЕЛЬКА>
-DwalletSource=<ПУТЬ К КОШЕЛЬКУ В JSON формате>
 
 
