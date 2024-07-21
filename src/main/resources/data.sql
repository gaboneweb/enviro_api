INSERT INTO Waste_Categories (category_id, name, description) VALUES
(next value for category_sequence, 'Plastic', 'Items made of plastic'),
(next value for category_sequence, 'Glass', 'Items made of glass'),
(next value for category_sequence, 'Paper', 'Items made of paper');


-- Insert test data into DisposalGuidelines
INSERT INTO Disposal_Guidelines (guideline_id, guideline, category_id) VALUES
(next value for guideline_sequence, 'Rinse before recycling.', 1),
(next value for guideline_sequence, 'Do not break glass.', 2),
(next value for guideline_sequence, 'Avoid wet paper.', 3);


-- Insert test data into RecyclingTips
INSERT INTO Recycling_Tips (tip_id, tip, category_id) VALUES
(next value for recycling_sequence, 'Check for the recycling symbol.', 1),
(next value for recycling_sequence, 'Remove any labels or caps.', 2),
(next value for recycling_sequence, 'Flatten boxes to save space.', 3);