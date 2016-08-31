To run test scripts:

1°) Install Node.js

2°) Create a Node application and install Chakram as a development dependency:
$> npm install --save-dev chakram

!!! Don't commit the files installed in node_modules directory !!!

3°) Install Mocha (globally) (chakram is build on top of Mocha)
$> npm install -g mocha

4°) You can set some parameters in the file params.js
ex:
    var env = envEnum.DEV;
or
    var env = envEnum.UAT;

5°) run tests with;
$> mocha path/to/testFile.js
(with testFile.js = test01.js...)
