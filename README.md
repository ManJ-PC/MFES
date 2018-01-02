# MFES

Practical work on VDM++

## Goals
 
The goal of this practical work is to develop, test and document an executable formal model of a high integrity software system in VDM++ using the Overture tool or the VDMTools. At the end of the work, students should have acquired the ability of formally modeling software systems in VDM++, and of demonstrating the consistency of the model. The work is to be performed by groups of two to three students attending the same class (turma). The groups will be defined and the themes assigned (different themes for different groups in the same class) in the practical classes of the week of 27 November to 1 December 2017.

## Deliverables

The project should be organized in a way similar to the Vending Machine example (see the MFES page in Moodle). The practical work should be concluded and the deliverables (final report, VDM++ project files, UML project files) submitted in a .zip file through Moodle until 11pm January 3. It may be applied a penalty of 2 (points out of 20) for each day late. The presentations will be scheduled for the first week of January (4th or 5th of January). Presentation is mandatory for ALL students. If you miss presentation you will get zero points out of twenty.

## Report Structure

You should incorporate the developed VDM++ classes in a single report (to be submitted in PDF format), written in English or Portuguese, covering the following items (which are also the assessment items):

Front page with authors, date and context (FEUP, MIEIC, MFES) ** [1%]

Informal system description and list of requirements **[10%]

a. Requirements should include any relevant constraints (regarding safety, etc.).

b. Each requirement should have an identifier.

c. You may have optional requirements.

Visual UML model **[5%]

a. A use case model, describing the system actors and use cases, with a short description of each major use case.

b. One or more class diagram(s), describing the structure of the VDM++ model, with a short description of each class, plus any other relevant explanations.

Formal VDM++ model **[50%]

a. VDM++ classes, properly commented.

b. Needed data types (e.g., String, Date, etc.) should be modeled with types, values and functions.

c. Domain entities should be modeled with classes, instance variables and operations. You are expected to make adequate usage of the VDM++ types (sets, sequences, maps, etc.) and create a model at a high level of abstraction.

d. The model should contain adequate contracts, i.e., invariants, preconditions, and postconditions. Postconditions need only be defined in cases where they are significantly different from the operation or function body (e.g., the postcondition of a sqrt(x) operation, which simply states that x = RESULT * RESULT, should be significantly different than the body); for learning purposes, you should define postconditions for at least two operations.

e. During the development of the project, if you foresee that the size of the VDM++ model will be less than 5 pages (or 7.5 pages in case of groups of 3 students) or more than 10 pages (or 15 pages in case of groups of 3 students), you should contact your teacher to possibly adjust the scope of the system or the modeling approach being followed.

Model validation (i.e., testing) **[20%]

a. VDM++ test classes, containing adequate and thorough test cases defined by means of operations or traces.

b. Evidences of test results (passed/failed) and test coverage. It is sufficient to present the system classes mentioned in 4 painted with coverage information. Ideally, 100% coverage should be achieved. Optionally, you may include figures of examples exercised in the test cases.

c. You should include requirements traceability relationship between test cases and requirements. Ideally, 100% requirements coverage should be achieved. It is sufficient to indicate in comments the requirements that are exercised by each test.

Model verification (i.e., consistency analysis) **[5%]

a. An example of domain verification, i.e., a proof sketch that a precondition of an operator, function or operation is not violated. You should present the proof obligation generated by the tool and your proof sketch.

b. An example of invariant verification, i.e., a proof sketch that the body of an operation preserves invariants. You should present the proof obligation generated by the tool and your proof sketch.

Code generation **[5%]

a. You should try to generate Java code from the VDM++ model and try to execute or test the generated code. Here you should describe the steps followed and results achieved.

Conclusions **[3%]

a. Results achieved.

b. Things that could be improved.

c. Division of effort and contributions between team members.

References **[1%]




Jyve empowers local musicians and bands by connecting them to venues through a mobile app.
Through the app you'll be able to create a profile, connect with musicians, sync your calendar, find
gigs and manage them all in one place. At Jyve we strive to solve the common problems in the local
music scene by creating the one stop app for musicians, bands, and venues.
See https://jyve.io/

Implement structures of VDM++
