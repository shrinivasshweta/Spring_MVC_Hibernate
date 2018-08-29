//POST
http://localhost:8080/KeepNote-Step3-Boilerplate/user/register       

{"userId":"1",
"userName":"shweta",
"userPassword":"123456",
"userMobile":"9690"}

{"userId":"2",
"userName":"smita",
"userPassword":"123456",
"userMobile":"9690283887"}

{"userId":"3",
"userName":"debashish",
"userPassword":"123456",
"userMobile":"96901234"}

//POST
http://localhost:8080/KeepNote-Step3-Boilerplate/login

{"userId":"1",
"userPassword":"123456"}


//PUT
http://localhost:8080/KeepNote-Step3-Boilerplate/user/1


//GET
http://localhost:8080/KeepNote-Step3-Boilerplate/user/1

--------------------------------------------------------------------------------------------------------------------

//POST
http://localhost:8080/KeepNote-Step3-Boilerplate/category

{"categoryName": "category1",
"categoryDescription": "categorydesc1",
"categoryCreatedBy": "1"}


{"categoryName": "category2",
"categoryDescription": "categorydesc2"}


//GET
http://localhost:8080/KeepNote-Step3-Boilerplate/category

//PUT
http://localhost:8080/KeepNote-Step3-Boilerplate/category/374

{"categoryName": "category2",
"categoryDescription": "newcategorydesc2"
}

----------------------------------------------------------------------------------------------------------------------

//POST
http://localhost:8080/KeepNote-Step3-Boilerplate/reminder
{"reminderName": "remindername1",
"reminderDescription":"reminderdesc",
"reminderType":"remindertype1"}

OUTPUT:

{
    "reminderId": 375,
    "reminderName": "remindername1",
    "reminderDescription": "reminderdesc",
    "reminderType": "remindertype1",
    "reminderCreatedBy": "2",
    "reminderCreationDate": null
}



{"reminderName": "remindername2",
"reminderDescription":"reminderdesc2",
"reminderType":"remindertype2"}
OUTPUT:

{
    "reminderId": 376,
    "reminderName": "remindername2",
    "reminderDescription": "reminderdesc2",
    "reminderType": "remindertype2",
    "reminderCreatedBy": "2",
    "reminderCreationDate": 1535521797018
}



//PUT
http://localhost:8080/KeepNote-Step3-Boilerplate/reminder/374


{"reminderName": "remindername2",
"reminderDescription":"newreminderdesc2",
"reminderType":"newremindertype2"}

OUTPUT:

Note not found

--------------------------------------------------------------------------------------------------------------------------------------------

//POST
http://localhost:8080/KeepNote-Step3-Boilerplate/note

{"noteTitle":"notetitle1",
"noteContent":"notecontent1",
"noteStatus":"status1"}


//POST
http://localhost:8080/KeepNote-Step3-Boilerplate/note

{"noteTitle":"notetitle1",
"noteContent":"notecontent1",
"noteStatus":"status1",
	"category": {
        "categoryId": 374,
        "categoryName": "category2",
        "categoryDescription": "categorydesc2",
        "categoryCreationDate": 1535518276000,
        "categoryCreatedBy": "2"
    },
"reminder":{
        "reminderId": 375,
        "reminderName": "remindername1",
        "reminderDescription": "reminderdesc",
        "reminderType": "remindertype1",
        "reminderCreatedBy": "2",
        "reminderCreationDate": null
    }

}
-------------------------------------------------------------------------------

//POST
http://localhost:8080/KeepNote-Step3-Boilerplate/note

{"noteTitle":"notetitle2",
"noteContent":"notecontent2",
"noteStatus":"status2",
	"category": {
        "categoryId": 374,
        "categoryName": "category2",
        "categoryDescription": "categorydesc2",
        "categoryCreationDate": 1535518276000,
        "categoryCreatedBy": "2"
    },
"reminder":{
        "reminderId": 375,
        "reminderName": "remindername1",
        "reminderDescription": "reminderdesc",
        "reminderType": "remindertype1",
        "reminderCreatedBy": "2",
        "reminderCreationDate": null
    }

}

OUTPUT:

[
    {
        "noteId": 379,
        "noteTitle": "notetitle2",
        "noteContent": "notecontent2",
        "noteStatus": "status2",
        "noteCreatedAt": 1535527637000,
        "category": {
            "categoryId": 374,
            "categoryName": "category2",
            "categoryDescription": "categorydesc2",
            "categoryCreationDate": 1535518276000,
            "categoryCreatedBy": "2"
        },
        "reminder": {
            "reminderId": 375,
            "reminderName": "remindername1",
            "reminderDescription": "reminderdesc",
            "reminderType": "remindertype1",
            "reminderCreatedBy": "2",
            "reminderCreationDate": null
        },
        "createdBy": "2"
    }
]
