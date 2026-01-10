### Problem statement

Suppose we have weather station which records the temperature and multiple devices ie display units.
Each display units wants to show the latest temperature. 

Without using observer pattern, the weather station should have to explicitly inform each device about the temperature
change which results in tight coupling between station and devices.