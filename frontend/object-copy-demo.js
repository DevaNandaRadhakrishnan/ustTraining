let nameData = {firstName: "John", lastName: "Smith"};
let personalData = {age: 23, gender:"Male"};

let combinedData = Object.assign(nameData, personalData);
console.log(combinedData)

let copyData = {...nameData, ...personalData}; //spread operator
document.write(copyData.age);

let oddNos = [3, 5, 7];
//let copyOdd = oddNos + [2, 4, 6];
let copyOdd = [...oddNos, ...[9, 11, 13]];
console.log(copyOdd);
console.log(oddNos);