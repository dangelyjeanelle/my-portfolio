// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random fact to the page.
 */
function addRandomFact() {
  const facts =
      [ 'I was born in Venezuela, so I am a native Spanish speaker', 
      'I learned to play the violin when I was 7 years old', 
      'I played Annie in the Venezuelan version of the musical, which helped me get over my fear of dogs.',
      'I came to the United States and joined math club at my school, where I met my best friends',
      'After failing to convince my family of getting a dog, I was excited to volunteer at the animal shelter',
      'In 2019, I graduated from Doral Academy',
      'I attended CSSI at Google. I did not know how to bike but that did not stop me from getting a photo',
      'Last year was my first ever doing cheerleading. Go tigers!',
      ];

  const images = 
      ['/images/1.jpg','/images/2.jpg','/images/3.jpg','/images/4.jpg',
      '/images/5.jpg','/images/6.jpg','/images/7.jpg','/images/8.jpg'
      ];

  // Pick a random fact.
  const rand = Math.floor(Math.random()*facts.length);
  const fact = facts[rand];
  const img = images[rand];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
  const image = document.getElementById('image');
  image.src = img;
}

function greetMe() {
  fetch('/data').then(response => response.json()).then((greet) => {

      const greetingElement = document.getElementById('greeting');
      greetingElement.innerHTML = '';
      greetingElement.append(createParagraph(greet.line1));
      greetingElement.append(createParagraph(greet.line2));
      greetingElement.append(createParagraph(greet.line3));
  });
}

function createParagraph(text) {
    const paragraph = document.createElement('p');
    paragraph.innerText = text;
    return paragraph;
}