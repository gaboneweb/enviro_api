-- Insert test data into WasteCategories
INSERT INTO Waste_Categories (category_id, name, description) VALUES
(next value for category_sequence, 'Plastic', 'Items made of plastic'),
(next value for category_sequence, 'Glass', 'Items made of glass'),
(next value for category_sequence, 'Paper', 'Items made of paper'),
(next value for category_sequence, 'Metal', 'Items made of metal'),
(next value for category_sequence, 'Organic', 'Biodegradable waste'),
(next value for category_sequence, 'Electronics', 'Electronic waste');

-- Insert test data into DisposalGuidelines
INSERT INTO Disposal_Guidelines (guideline_id, guideline, category_id) VALUES
(next value for guideline_sequence, 'Rinse before recycling.', 1),
(next value for guideline_sequence, 'Do not break glass.', 2),
(next value for guideline_sequence, 'Avoid wet paper.', 3),
(next value for guideline_sequence, 'Remove labels and caps.', 1),
(next value for guideline_sequence, 'Separate by color.', 2),
(next value for guideline_sequence, 'Shred confidential documents.', 3),
(next value for guideline_sequence, 'Remove non-metal parts.', 4),
(next value for guideline_sequence, 'Compost if possible.', 5),
(next value for guideline_sequence, 'Remove batteries.', 6),
(next value for guideline_sequence, 'Recycle at designated centers.', 6);

-- Insert test data into RecyclingTips
INSERT INTO Recycling_Tips (tip_id, tip, category_id) VALUES
(next value for recycling_sequence, 'Check for the recycling symbol.', 1),
(next value for recycling_sequence, 'Remove any labels or caps.', 2),
(next value for recycling_sequence, 'Flatten boxes to save space.', 3),
(next value for recycling_sequence, 'Wash thoroughly before recycling.', 1),
(next value for recycling_sequence, 'Avoid mixing different types of glass.', 2),
(next value for recycling_sequence, 'Reuse paper if possible.', 3),
(next value for recycling_sequence, 'Crush cans to save space.', 4),
(next value for recycling_sequence, 'Compost kitchen scraps.', 5),
(next value for recycling_sequence, 'Donate old electronics.', 6),
(next value for recycling_sequence, 'Look for e-waste recycling programs.', 6);