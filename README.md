# bulk-intent-upload
This application will consolidate the entire dataset of questions and responses and create a zip archive file containing the intents in a folder along with agent and package json files. This can be imported in DialogFlow to train an agent.
The only restriction is there cannot be multiple responses for the same intent.

The following information has to be configured using a config.properties file:

excel.file.path = <the path to the excel file with extension>
excel.sheet.name = <excel worksheet name>
output.folder = <the folder where you want the output zipped file>
output.zip.name = <the name of the final zip file that is generated with extension>
column.number.for.question = <provide the column number where the question is present in the excel file>
column.number.for.response = <provide the column number where the response is present in the excel file>
column.number.for.intent = <provide the column number where the intent is present in the excel file>
agent.name = <provide a name for agent>

This application works on the assumption that intent is an integer value.

Download this project, execute maven build with the goal package. You'll get the binary jar file with dependencies. Create a folder titled 'config' and place the config.properties into the folder after filling up all the values.

Execute the jar file by double-clicking on it. It will process all the intents and generate a zip archive file with the name as specified in the config.properties file. You can directly upload the generated zip file under Export and Import tab under agent settings.
