# bulk-intent-upload
This application will consolidate the entire dataset of questions and responses and create a zip archive file containing the intents in a folder along with agent and package json files. This can be imported in DialogFlow to train an agent.

There are 2 restrictions for the data in excel file
1. There cannot be multiple responses for the same intent.
2. The intent column has to contain an integer value.

The following information has to be configured using a config.properties file:

```
excel.file.path = <the path to the excel file with extension>
excel.sheet.name = <excel worksheet name>
output.folder = <the folder where you want the output zipped file>
output.zip.name = <the name of the final zip file that is generated with extension>
column.number.for.question = <provide the column number where the question is present in the excel file>
column.number.for.response = <provide the column number where the response is present in the excel file>
column.number.for.intent = <provide the column number where the intent is present in the excel file>
agent.name = <provide a name for agent>
```

### Building and executing the application
1. Download this project.
2. Execute maven build with the goal as package.
3. You'll get the binary jar file with dependencies.
4. Create a config.properties file and populate it with the above mentioned fields or make modifications to the existing config.properties file in config folder.
5. Execute the jar file with dependencies by double-clicking will process all the intents and generate a zip archive file with the name as specified in the config.properties file.

You can directly upload the generated zip file under Export and Import tab under agent settings in DialogFlow.
