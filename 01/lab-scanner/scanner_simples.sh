#!/bin/bash
while IFS= read -r linha; do
  clean=$(echo "$linha" | tr -d ' \t\r')
  echo "[SCANNER] Linha: '$linha'"
  echo "[CLEAN]   Sem espaços: '$clean'"
done
