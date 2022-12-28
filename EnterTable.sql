use
Car
go

BEGIN
TRANSACTION
INSERT INTO Type_Car VALUES
('T000000001', 'CONVERTIBLE', 'Does the roof retract into the body leaving the passenger cabin open to the elements? If so, its a convertible. Most convertibles have a fully powered fabric roof that folds down, but a few have to be lowered by hand. There are also a number of models with a retractable hardtop, as well as several unusual quasi-convertibles (called "targa tops") like the Mazda MX-5 Miata RF, Porsche 911 Targa and Corvette; only the forward section of their roofs retracts or can be removed by hand.'),
('T000000002', 'SPORT-UTILITY VEHICLE', 'SUVs�often also referred to as crossovers�tend to be taller and boxier than sedans, offer an elevated seating position, and have more ground clearance than a car. They include a station wagon-like cargo area that is accessed through a flip-up rear hatch door, and many offer all-wheel drive. The larger ones have three rows of seats. Sizes start at subcompact (Hyundai Kona, Nissan Kicks), mid-size, and go all the way to full-size (Ford Expedition, Chevrolet Tahoe). Luxury brands offer many SUV models in most of the same size categories.'),
('T000000003', 'MINIVAN', 'Minivans are the workhorses of the family-car world, the best at carrying people and cargo in an efficient package. Theyre called minivans but they are far from "mini." Thats because they are tall boxes-on-wheels with sliding side doors for easy access and a rear hatch that opens to a large cargo area. Most minivans have adjustable seats in their second and third rows that often can be removed or even folded into the floor to create a huge open cargo bay. The Honda Odyssey and Chrysler Pacifica are great examples of the breed.'),
('T000000004', 'PICKUP TRUCK', 'A pickup truck has a passenger cab and an open cargo bed in the rear. Virtually all pickups offer some form of all-wheel drive or part-time four-wheel drive�the latter for off-road use only. With one exception�the mid-sized Honda Ridgeline�pickup bodies are cabs mounted to a separate steel frame. The Ridgeline is more like a crossover with the rear section of the roof lopped off to expose a cargo bed. Currently, pickup trucks come in two size categories: full-size and mid-size.')
GO
COMMIT
GO

BEGIN
TRANSACTION
INSERT INTO Car VALUES
('C000000001', 'Specially formulated gasoline is essentially the only fuel used for automobile operation, although diesel fuels are used for many trucks and buses and a few automobiles, and compressed liquefied hydrogen has been used experimentally. The most important requirements of a fuel for automobile use are proper volatility, sufficient antiknock quality, and freedom from polluting by-products of combustion. The volatility is reformulated seasonally by refiners so that sufficient gasoline vaporizes, even in extremely cold weather, to permit easy engine starting. Antiknock quality is rated by the octane number of the gasoline. ', 'T000000002'),
('C000000002', 'A wide range of engines has been used experimentally and in automotive production. The most successful for automobiles has been the gasoline-fueled reciprocating-piston internal-combustion engine, operating on a four-stroke cycle, while diesel engines are widely used for trucks and buses.', 'T000000001'),
('C000000003', 'In most passenger cars through the middle of the 20th century, a pressed-steel frame�the vehicle�s chassis�formed a skeleton on which the engine, wheels, axle assemblies, transmission, steering mechanism, brakes, and suspension members were mounted. The body was flexibly bolted to the chassis during a manufacturing process typically referred to as body-on-frame construction. This process is used today for heavy-duty vehicles, such as trucks, which benefit from having a strong central frame, subjected to the forces involved in such activities as carrying freight, including the absorption of the movements of the engine and axle that is allowed by the combination of body and frame.', 'T000000004'),
('C000000004', 'Automotive body designs are frequently categorized according to the number of doors, the arrangement of seats, and the roof structure. Automobile roofs are conventionally supported by pillars on each side of the body. Convertible models with retractable fabric tops rely on the pillar at the side of the windshield for upper body strength, as convertible mechanisms and glass areas are essentially nonstructural. Glass areas have been increased for improved visibility and for aesthetic reasons.', 'T000000003')
GO
COMMIT
GO
