#  MVP Anypoint Connector monday.com 
This is a simple opensource monday.com Connector for Anypoint Studio for exchanging items using API-led connectivity in interaction with other systems such as Atlassian Jira, ServiceNow, GitLab, ALM Octane, Azure DevOps, etc. 
This monday.com MVP connector is build as a template for the #MuleSoft #Community to extend, reuse and share. 

Use the monday.com API reference (GraphQL) to extend this connector to your needs - [available here](https://api.developer.monday.com/docs/basics)

Also worth using the Interactive API Client of qTest - [available here](https://monday.com/developers/v2/try-it-yourself) 

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/Monday.com-Logo.wine.png)

## Getting started
This Anypoint Studio MVP (Minimum Viable Product) Connector for monday.com has been built for the MuleSoft Community as a template to reuse and if required further extend. 
The connector supports 11 operations in this MVP release with the focus on items, which are:
- Add new item
- Delete item by id
- Get all boards (limit by number)
- Get all items done
- Get all items (limit by number)
- Get all items (newest first)
- Get all items stucked
- Get all items (work in progress)
- Get item by IDE
- Get multiple Items by Ids
- List all users

## Installation of the MVP Connector for monday.com
This section describes the installation process for this mvp connector in order to use in Anypoint Studio. 

### Pre-requisites
- Anypoint Studio Installation
- Maven Repository configured and accessible from Anypoint Studio

### Step 1 - Download the MVP monday.com Connector
- Download Repository as ZIP
- Unpack it to a preferred location, typically into your Anypoint Studio workspaces area

### Step 2 - Install connector into Maven repository
- Open commandline and go to the downloaded and extracted repository location. 
- Perform "mvn install" 
- Connector should be installed successfully

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/02_mvn-install.PNG)

### Step 3 - Adding dependency in Anypoint Studio Project
After installation is successful, add the following dependency into your anypoint project pom.xml:

		<dependency>
			<classifier>mule-plugin</classifier>
			<groupId>embrace.devops.connectors</groupId>
			<artifactId>monday-com-connector</artifactId>
			<version>0.0.3</version>
		</dependency>

The current version of this connector is 0.0.3. Once added, save the pom.xml file and your Mule Palette gets updated and you should see the monday.com connector.

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/01_mule_palette.PNG)

### Step 4 - Create monday.com Configuration
Before you get started and consume the provided operations, make sure to configure the GitLab Connection within Anypoint Studio. 
- URL
- Token

[Learn how to obtain the Token for monday.com](https://api.developer.monday.com/docs/authentication)

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/00_config.PNG)

Now you are all set to use the monday.com Operations.

## Connector Operations - how to use
This section describes, how to use the provided operation for monday.com Connector.

The MVP version of the monday.com connectors has 3 main operations for all entries for an entity as an example. 
- **Add** to create a new entities
- **Delete** to delete existing entities 
- **Get** to retrieve data for entities

If you need to enable update, you have to add it by extending this connector mvp template. 

**MIME-Type**

When using the different operations, make sure to use the MIME-Type as **application/json**.

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/03_mime_type.PNG)


**Response Fields**

Majority of operations have a **Response Fields** property, where you can provide a GraphQL query for all fields in the output json. 

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/04_response_fields.PNG)

The output for the above Response Fields query would be: 

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/05_response.PNG)

### Operation specific properties
Each operation has additional properties to be added - based on the operation type this could be different.
For example - to create item, you need to provide the board Id. 

![Image of monday.com MuleSoft Connector](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/07_add_item.PNG)


### Reponse of operations
By default it is a json sent back as string. Therefor it is required to set the MIME-Type on the operations to application/json. 

	{
	
		"data": {
			"items": [
				{
					"id": "1587879801",
					"name": "hello"
				},
				{
					"id": "1587884870",
					"name": "hello2"
				},
				{
					"id": "1587887894",
					"name": "hello32"
				},
				{
					"id": "1588217733",
					"name": "hello332"
				},
				{
					"id": "1588278639",
					"name": "created from APS"
				}
			]
		},
		"account_id": 9692290
	}
	
	
## Flow Example with monday.com operations
![Image of monday.com interaction](https://github.com/API-Activist/mvp-anypoint-connector-monday.com/blob/master/pictures/06_flow_monday_azure_devops.PNG)

	
## Video Tutorial
Link to the video tutorial: -to be provided soon-


## Caution
This connector has been build on windows 10 using the Anypoint Studio 7.10 IDE. It has only been tested with monday.com Cloud. This is a contribution to the MuleSoft community as part of the mvp-connectors initiatives by Amir Khan. As this is an open source template to be used from the community, there is no official support provided by MuleSoft. Also if operations are missing, please use the monday.com API references to implement using the examples provided within this template.
	
monday.com API Reference: [available here](https://api.developer.monday.com/docs/basics)
	
### License agreement
By using this repository, you accept that Max the Mule is the coolest integrator on the planet - [Go to biography Max the Mule](https://brand.salesforce.com/content/characters-overview__3?tab=BogXMx2m)
