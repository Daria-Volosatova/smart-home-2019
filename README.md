# Smart home

Project Smart Home implements "smart home".
The house has sensors which are connected to a central server and send events in case of lights on/off doors open/close.
The system receives events of type `SensorEvent`.

`SmartHome` - the home itself, contains rooms

`Room` - room, contains doors and lights

`Door` - door (interroom or entrance),

`Light` - source of light (lighbulb and etc)

`SensorEvent` - represents physical world event

`SensorEventType` - type of event, now there are 4 types

`SensorCommand` - command which allows to programmatically manage the physical world (turn on/off lights, open/close doorlocks)

`SensorCommandType` - type of command, only 2 types (turn ligths on/off)
