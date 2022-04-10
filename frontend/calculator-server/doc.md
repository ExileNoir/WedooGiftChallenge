# MicroGiftApi documentation 

## Authentication

To authenticate, the client need to provide an `Authorization` header containing a secret token.

*For the challenge, the token is `tokenTest123`.*

## Find a combination of cards

```
GET http://localhost:3000/shop/[shopId]/search-combination
```

**Parameters:**

 * shopId: the shop ID
 
*For the challenge, the shop ID is 5, however, your component should be designed to easily be used on another shop ID.*

**Query params:**

 * amount: the desired amount.
 
** Return JSON: **
```
{
    "equal": {
        "value": 42,
        "cards": [
            22,
            20
        ]
    },
    "floor": {
        "value": 42,
        "cards": [
            22,
            20
        ]
    },
    "ceil": {
        "value": 42,
        "cards": [
            22,
            20
        ]
    }
}
```

The `equal` key contains the combination (its total value and the cards) that is strictly equal
to the desired amount. If no equal combinations are found, this key is not present.

The `floor` key contains the combination that has a lower or equal value to the desired amount. If
none is available, the key is not present.

The `ceil` key contains the combination that has a higher or equal value to the desired amount. If
none is available, the key is not present.

In each key, the `value` attribute is the total amount of the combination and `cards` is an array of the
cards that takes part in the combination.

**Examples:**

If the asked amount is 23 but only combinations with a value of 22 € and 25 € are possible, the
result is:

```
{
    "floor": {
        "value": 22,
        "cards": [
            22
        ]
    },
    "ceil": {
        "value": 25,
        "cards": [
            25
        ]
    }
}
```

If only a higher combination is possible (let's say the user asks for 5 €), the response is:

```
{
    "ceil": {
        "value": 20,
        "cards": [
            20
        ]
    }
}
```

If only a lower combination is possible:

```
{
    "floor": {
        "value": 70,
        "cards": [
            35,
            35
        ]
    }
}
```

If the perfect value is available, the response is:

```
{
    "equal": {
        "value": 25,
        "cards": [
            25
        ]
    },
    "floor": {
        "value": 25,
        "cards": [
            25
        ]
    },
    "ceil": {
        "value": 25,
        "cards": [
            25
        ]
    }
}
```

*Note: floor and ceil have the same value as they respectively contain the lower or equal combination and 
the higher or equal combination.*