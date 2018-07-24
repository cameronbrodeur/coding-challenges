// 681. Next Closest Time
//
// Given a time represented in the format "HH:MM", form the next closest time by 
// reusing the current digits. There is no limit on how many times a digit can be 
// reused.
//
// You may assume the given input string is always valid. For example, "01:34", 
// "12:09" are all valid. "1:34", "12:9" are all invalid.
//
// Example 1:
//
// Input: "19:34"
// Output: "19:39"
// Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, 
// which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours 
// and 59 minutes later.
//
// Example 2:
//
// Input: "23:59"
// Output: "22:22"
// Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. 
// It may be assumed that the returned time is next day's time since it is smaller 
// than the input time numerically.
//
// Companies asking this question:
//      Google - Online assessment question.

/**
 * @param {string} time
 * @return {string}
 */
var nextClosestTime = function(time) {
    // Extract all of the digits in 'time' and put into a dictionary for quick lookup
    let digitsArray = time.split('');
    let digits = {};
    for (let digit of digitsArray) {
        if (digit != ':') {
            digits[digit] = true;
        }
    }

    // Extract the HH and MM as numbers from 'time' for quick comparisons
    const startHH = Number(time.slice(0, 2));
    const startMM = Number(time.slice(3, 5));

    // Find the nearest minute to startMM
    let onesPlace, tensPlace, nextMM, nextMMStr;
    for (let minutes = 1; minutes <= 60; minutes++) {
        nextMM = (startMM + minutes) % 60;

        if (nextMM < 10) {
            tensPlace = '0';
        } else {
            tensPlace = Math.floor(nextMM / 10).toString();
        }
        onesPlace = Math.floor(nextMM % 10).toString();

        if (digits[onesPlace] && digits[tensPlace]) {
            nextMMStr = tensPlace + onesPlace;
            break;
        }
    }

    if ((nextMM > startMM) && (nextMM < 60)) {  // The closest time occurs within the same hour
        if (startHH < 10) {
            return '0' + startHH.toString() + ':' + nextMMStr;
        } else {
            return startHH.toString() + ':' + nextMMStr;
        }
    }

    // Find the nearest hour to startHH
    let nextHH, nextHHStr;
    for (let hours = 1; hours <= 24; hours++) {
        nextHH = (startHH + hours) % 24;

        if (nextHH < 10) {
            tensPlace = '0';
        } else {
            tensPlace = Math.floor(nextHH / 10).toString();
        }
        onesPlace = Math.floor(nextHH % 10).toString();

        if (digits[onesPlace] && digits[tensPlace]) {
            nextHHStr = tensPlace + onesPlace;
            break;
        }
    }

    return nextHHStr + ':' + nextMMStr;
};

var nextClosestTime_v2 = function(time) {
    // Calculate the start time in minutes elapsed from midnight
    // current = (60 * HH) + MM
    let current = 60 * time.slice(0, 2);
    current += Number(time.slice(3)); 

    // Extract all of the digits in 'time' and put into a dictionary for quick lookup
    let allowed = {};
    for (let digit of time.split('')) {
        if (digit != ':') {
            allowed[digit] = true;
        }
    }

    while(true) {
        current = (current + 1) % (24 * 60);
        let digits = [Math.floor(current / 60 / 10), Math.floor(current / 60 % 10), Math.floor(current % 60 / 10), Math.floor(current % 60 % 10)];
        if (allowed[digits[0]] && allowed[digits[1]] && allowed[digits[2]] && allowed[digits[3]]) {
            return digits[0].toString() + digits[1].toString() + ':' + digits[2].toString() + digits[3].toString();
        }
    }
}

function test(func) {
    console.log("\nTesting nextClosestTime(time)...\n");

    let time, result;

    time = "19:34";
    result = func(time);
    console.log('Expected: 19:39');
    console.log('Output:   ' + result);

    time = "23:59";
    result = func(time);
    console.log('Expected: 22:22');
    console.log('Output:   ' + result);

    time = "01:32";
    result = func(time);
    console.log('Expected: 01:33');
    console.log('Output:   ' + result);
}

test(nextClosestTime);
test(nextClosestTime_v2);