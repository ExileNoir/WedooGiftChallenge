var express = require('express');
var router = express.Router();

var testToken = 'tokenTest123';
var acceptedShopId = '5';

var possibleCombinations = [
    { value: 20, cards: [20] },
    { value: 22, cards: [22] },
    { value: 25, cards: [25] },
    { value: 26, cards: [26] },
    { value: 35, cards: [35] },
    { value: 40, cards: [20, 20] },
    { value: 42, cards: [22, 20] },
    { value: 45, cards: [45] },
    { value: 51, cards: [26, 25] },
    { value: 55, cards: [35, 20] },
    { value: 57, cards: [35, 22] },
    { value: 70, cards: [35, 35] }
];


/* GET home page. */
router.get('/shop/:shopId/search-combination', function(req, res, next) {
  if (req.header('Authorization') !== testToken) {
    res.status(401).json({ status: 401, message: 'Invalid token!' });
    return;
  }

  if (req.params.shopId !== acceptedShopId) {
    res.status(400).json({ status: 400, message: 'Shop not found!' });
    return;
  }

  var desiredAmount = req.query.amount;
  if (desiredAmount === undefined || isNaN(desiredAmount)) {
    res.status(400).json({ status: 400, message: 'Invalid amount!' });
    return;
  }

  desiredAmount = +desiredAmount;

  var lowerIndex;
  var equalIndex;
  var upperIndex;
  possibleCombinations.forEach((combination, index) => {
    if (combination.value <= desiredAmount) {
      lowerIndex = index;
    }
    if (combination.value >= desiredAmount && upperIndex === undefined) {
      upperIndex = index;
    }
    if (combination.value === desiredAmount) {
      equalIndex = index;
    }
  });
  res.json({
    equal: equalIndex !== undefined ? possibleCombinations[equalIndex] : undefined,
    floor: lowerIndex !== undefined ? possibleCombinations[lowerIndex] : undefined,
    ceil: upperIndex !== undefined ? possibleCombinations[upperIndex] : undefined
  });
});

module.exports = router;
