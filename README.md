## API Documentation
### Register API
| HTTP Method | URL |
| -- | -- |
| GET | `/transactions/` |

**Response Body**

```json
[
    {
        "id": 1,
        "voucherId": null,
        "transactionDate": "2024-05-26T14:54:22.554+00:00",
        "totalAmount": 1280000,
        "status": null,
        "username": "User2"
    },
    {
        "id": 2,
        "voucherId": 4,
        "transactionDate": "2024-05-26T15:29:10.593+00:00",
        "totalAmount": 21000,
        "status": "Processing",
        "username": "fancom"
    }
]
```

| HTTP Method | URL |
| -- | -- |
| GET | `/transactions/{id}` |

**Response Body**

```json
{
    "id": 1,
    "voucherId": null,
    "transactionDate": "2024-05-26T14:54:22.554+00:00",
    "totalAmount": 1280000,
    "status": null,
    "username": "User2"
}
```

| HTTP Method | URL |
| -- | -- |
| GET | `/transactions/users/{username}` |

**Response Body**

```json
[
    {
        "id": 1,
        "voucherId": null,
        "transactionDate": "2024-05-26T14:54:22.554+00:00",
        "totalAmount": 1280000,
        "status": null,
        "username": "User2"
    },
    {
        "id": 2,
        "voucherId": 4,
        "transactionDate": "2024-05-26T15:29:10.593+00:00",
        "totalAmount": 21000,
        "status": "Processing",
        "username": "fancom"
    }
    {
        "id": 2,
        "voucherId": 4,
        "transactionDate": "2024-05-26T15:29:10.593+00:00",
        "totalAmount": 21000,
        "status": "Processing",
        "username": "fancom"
    }
]
```

| HTTP Method | URL |
| -- | -- |
| POST | `/transactions/` |

**Request Body**
```json
{
    "totalAmount": 1280000,
    "username": "User2"
}
```

**Response Body**
```json
{
    "id": 2,
    "voucherId": null,
    "transactionDate": "2024-05-26T14:54:22.554+00:00",
    "totalAmount": 1280000,
    "status": null,
    "username": "User2"
}
```

| HTTP Method | URL |
| -- | -- |
| PUT | `/transactions/{id}` |

**Request Body**
```json
{
    "totalAmount": 1280000,
    "username": "User2"
}
```

**Response Body**
```json
{
    "id": 2,
    "voucherId": null,
    "transactionDate": "2024-05-26T14:54:22.554+00:00",
    "totalAmount": 1280000,
    "status": null,
    "username": "User2"
}
```


