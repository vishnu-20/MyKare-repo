# MyKare-repo

Find the Controller Ebd point and Request 

--------------------------------------------


Add User
-----------
POST : http://localhost:9090/user

Request :
{
    "firstName": "vishnu",
    "lastName": "lal",
   "gender": "male",
     "email": "vishnu@gmail1.com",
    "password": "Vishnu@123"
  
}

Get All
-----------

GET : http://localhost:9090/user/all

Delete 
-------------

DELET : http://localhost:9090/delete/{email}

Login
-----------
POST : http://localhost:9090/authenticate  

Request : 

{
   
    "email": "vishnu@gmail1.com",
    "password": "Vishnu@123"
  
}
