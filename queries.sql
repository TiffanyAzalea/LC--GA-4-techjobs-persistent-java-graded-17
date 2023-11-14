--Part 1
CREATE TABLE job (
    employer VARCHAR
    location VARCHAR
    positionType VARCHAR
    coreCompetency VARCHAR
)
--Part 2
SELECT name FROM employer WHERE location = "St. Louis City";
--Part 3
DROP TABLE job;


--Part 4
SELECT *
FROM skill
LEFT JOIN job_skillS ON skill.id = job_skills.skills_id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY namE ASC;
