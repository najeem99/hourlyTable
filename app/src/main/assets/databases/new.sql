BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "mech_s6_a" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"p1"	TEXT,
	"p2"	TEXT,
	"p3"	TEXT,
	"p4"	TEXT,
	"p5"	TEXT,
	"p6"	TEXT,
	"p7"	TEXT,
	"p8"	TEXT
);
CREATE TABLE IF NOT EXISTS "cse_s6_b" (
	"id"	INTEGER NOT NULL,
	"p1"	TEXT,
	"p2"	TEXT,
	"p3"	TEXT,
	"p4"	TEXT,
	"p5"	TEXT,
	"p6"	TEXT,
	"p7"	TEXT,
	"p8"	TEXT
);
CREATE TABLE IF NOT EXISTS "civil_s6_b" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"p1"	TEXT,
	"p2"	TEXT,
	"p3"	TEXT,
	"p4"	TEXT,
	"p5"	TEXT,
	"p6"	TEXT,
	"p7"	TEXT,
	"p8"	TEXT
);
CREATE TABLE IF NOT EXISTS "mech_s6_c" (
	"id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"p1"	TEXT,
	"p2"	TEXT,
	"p3"	TEXT,
	"p4"	TEXT,
	"p5"	TEXT,
	"p6"	TEXT,
	"p7"	TEXT,
	"p8"	TEXT
);
INSERT INTO "mech_s6_a" VALUES (1,'Machine Design','Metrology and Mechanical/Library','Metrology and Mechanical/Library','Metrology and Mechanical/Library','LUNCH','Heat and Mass transfer Lab','Heat and Mass transfer Lab','Heat and Mass transfer Lab');
INSERT INTO "mech_s6_a" VALUES (2,'PE-1:Design of jigs /Composite materials/Renewable','PE-1:Design of jigs /Composite materials/Renewable','Maths elective II','Maths elective II','LUNCH','Metrology and Mechanical/Library','Metrology and Mechanical/Library','Metrology and Mechanical/Library');
INSERT INTO "mech_s6_a" VALUES (3,'PE-2:Industrial Safety/Failure Anal/Renewable/Process Planning','CNC Lab/Heat and Mass transfer Lab','CNC Lab/Heat and Mass transfer Lab','CNC Lab/Heat and Mass transfer Lab','LUNCH','Metrology and Mechanical Measurements','English','English');
INSERT INTO "mech_s6_a" VALUES (4,'PE-2:Industrial Safety/Failure Anal/Renewable/Process Planning','PE-2:Industrial Safety/Failure Anal/Renewable/Process Planning','PE-1:Design of jigs /Composite materials/Renewable','Machine Design','LUNCH','Heat and Mass transfer','Heat and Mass transfer','Metrology and Mechanical Measurements');
INSERT INTO "mech_s6_a" VALUES (5,'Leadership and CEO','Leadership and CEO','Machine Design','Machine Design','LUNCH','Prayer','Metrology and Mechanical Measurements','Heat and Mass transfer');
INSERT INTO "cse_s6_b" VALUES (1,'database security','social media security','BIG DATA','SEM','LUNCH','DISTRIBUTED COMPUTING','GRAPH THEORY','LIBRARY');
INSERT INTO "cse_s6_b" VALUES (2,'GRAPH THEORY','DISTRIBUTED COMPUTING','MATHS','MATHS','LUNCH','BIG DATA/APP DEVELOPMENT - LAB','BIG DATA/APP DEVELOPMENT - LAB','BIG DATA/APP DEVELOPMENT - LAB');
INSERT INTO "cse_s6_b" VALUES (3,'social media security','BIG DATA','LIBRARY','GRAPH THEORY','LUNCH','GRAPH THEORY','LIBRARY','SEM');
INSERT INTO "cse_s6_b" VALUES (4,'BIG DATA','DISTRIBUTED COMPUTING','ENGLISH','ENGLISH','LUNCH','ENTREPREUNER / APP Dev/BIG DATA','ENTREPREUNER / APP Dev/BIG DATA','ENTREPREUNER / APP Dev/BIG DATA');
INSERT INTO "cse_s6_b" VALUES (5,'database security','ENTREPREUNER / APP Dev/BIG DATA','ENTREPREUNER / APP Dev/BIG DATA','ENTREPREUNER / APP Dev/BIG DATA','LUNCH','PRAYER','social media security','database security');
INSERT INTO "civil_s6_b" VALUES (1,'Building Services/Remote sensing','Comp Modelling LAB/Survey & Geotechnical Investigation Camp','Comp Modelling LAB/Survey & Geotechnical Investigation Camp','Comp Modelling LAB/Survey & Geotechnical Investigation Camp','LUNCH','Leadership &CEO training','Geotechnical Engineering II','Geotechnical Engineering II');
INSERT INTO "civil_s6_b" VALUES (2,'Repair / Ground Techniques / Housing,planning','Repair / Ground Techniques / Housing,planning','Maths
','Maths','LUNCH','Geotechnical Engineering II','Design of steel Structures','Design of steel Structures');
INSERT INTO "civil_s6_b" VALUES (3,'Structural Analysis I','Structural Analysis I','Design of steel Structures','Building Services/Remote sensing','LUNCH','Comp Modelling LAB/Survey & Geotechnical Investigation Camp','Comp Modelling LAB/Survey & Geotechnical Investigation Camp','Comp Modelling LAB/Survey & Geotechnical Investigation Camp');
INSERT INTO "civil_s6_b" VALUES (4,'Repair / Ground Techniques / Housing,planning','Leadership &CEO training','Geotechnical Engineering II','Design of steel Structures','LUNCH','Structural Analysis I','Structural Analysis I','Design of steel Structures');
INSERT INTO "civil_s6_b" VALUES (5,'Geotechnical Engineering II','Building Services/Remote sensing','English','English','LUNCH','Prayer','Structural Analysis I','Leadership &CEO training');
INSERT INTO "mech_s6_c" VALUES (1,'Metrology and Mechanical lab','CNC lab/Heat & Mass transfer Lab','CNC lab/Heat & Mass transfer Lab','CNC lab/Heat & Mass transfer Lab','LUNCH','Machine Design','Leadership & CEO Training','Leadership & CEO Training');
INSERT INTO "mech_s6_c" VALUES (2,'PE1-Design of Jigs/Composite Materials/Renewable sources','PE1-Design of Jigs/Composite Materials/Renewable sources','PE2-Industrial safe/Failure anal/Renewable/process planning','PE2-Industrial safe/Failure anal/Renewable/process planning','LUNCH','Heat and Mass Transfer','Heat and Mass Transfer','Metrology and Mechanical lab');
INSERT INTO "mech_s6_c" VALUES (3,'PE2-Industrial safe/Failure anal/Renewable/process planning','Metrology and Mechanical lab/Library','Metrology and Mechanical lab/Library','Metrology and Mechanical lab/Library','LUNCH','Heat and Mass Transfer','Machine Design','Machine Design');
INSERT INTO "mech_s6_c" VALUES (4,'PE2-Industrial safe/Failure anal/Renewable/process planning','PE2-Industrial safe/Failure anal/Renewable/process planning','PE1-Design of Jigs/Composite Materials/Renewable sources','Machine Design','LUNCH','Metrology and Mechanical lab/Library','Metrology and Mechanical lab/Library','Metrology and Mechanical lab/Library');
INSERT INTO "mech_s6_c" VALUES (5,'Metrology and Mechanical lab','CNC lab/Heat & Mass transfer Lab','CNC lab/Heat & Mass transfer Lab','CNC lab/Heat & Mass transfer Lab','LUNCH','Prayer','English','English');
COMMIT;
